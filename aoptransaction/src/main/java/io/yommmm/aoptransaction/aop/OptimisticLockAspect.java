package io.yommmm.aoptransaction.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
@Aspect
@Component
@Slf4j
public class OptimisticLockAspect {

    @Around(value = "@annotation(OptimisticLock) && @annotation(optimisticLock)")
    @Transactional
    public void aspect(ProceedingJoinPoint pjp, OptimisticLock optimisticLock) throws Throwable {
        String value = optimisticLock.id();
        log.info("value is {}", value);

        Object[] args = pjp.getArgs();

        pjp.proceed();

        if ("".equals(value)) {
//            throw new RuntimeException("hehe");
        }

        log.info("success");
    }

}
