package com.boot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TxTransactionService {
	
	private static final String TX_M_START = "TX_MANAGER_START";
	
	private static final String TX_M_START_FAILED = "TX_MANAGER_START_FAILED";
	
	private static final String TX_M_START_FINISHED = "TX_MANAGER_START_FINISHED";
	
	private static final String TX_M_SERVICE = "TX_MANAGER_SERVICE";
	
	private static final String TX_M_SERVICE_FAILED = "TX_MANAGER_SERVICE_FAILED";
	
	private static final String TX_M_SERVICE_FINISHED = "TX_MANAGER_SERVICE_FINISHED";
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Around(value = "@annotation(TxTransaction) && @annotation(txTransaction)")
	public void txTransaction(ProceedingJoinPoint pjp, TxTransaction txTransaction) {
		
		// 1.判断Redis是否正常，若不正常，按什么策略处理
		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		if(null != connection) {
			String traceId = MDC.get("trace_id");
			ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
			
			// 2.判断是否为事务发起方
			if(txTransaction.isStart()) {
				opsForValue.set(traceId, TX_M_START);
			} else {
				String value = opsForValue.get(traceId);
				if(TX_M_START.equals(value)) {
					opsForValue.set(traceId, TX_M_SERVICE);
				}
			}
			
			try {
				// 3.执行被切方法
				pjp.proceed();
			} catch (Throwable e) {
				// 4.执行失败，抛出运行时异常进行事务回滚
				opsForValue.set(traceId, txTransaction.isStart() ? TX_M_START_FAILED : TX_M_SERVICE_FAILED);
				
				throw new RuntimeException("Unknow Exception!");
			} finally {
				opsForValue.set(traceId, txTransaction.isStart() ? TX_M_START_FINISHED : TX_M_SERVICE_FINISHED);
			}
			
			if(txTransaction.isStart()) {
				boolean loop = true;
				while(loop) {
					String startStatus = opsForValue.get(traceId);
					if(TX_M_SERVICE_FAILED.equals(startStatus))
						throw new RuntimeException("The Invoked Party Transaction Exception");
						loop = false;
					
					if(TX_M_SERVICE_FINISHED.equals(startStatus))
						loop = false;
				}
			} else {
				boolean loop = true;
				while(loop) {
					String startStatus = opsForValue.get(traceId);
					if(TX_M_START_FAILED.equals(startStatus))
						throw new RuntimeException("Caller Transaction Exception!");
						loop = false;
					
					if(TX_M_START_FINISHED.equals(startStatus))
						loop = false;
				}
				
			}
			
		}
		
	}
	
}
