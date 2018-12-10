package com.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zuul.config.Constants;

@Component
public class TokenFilter extends ZuulFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

	/**
	 * 过滤器执行的方法
	 */
	@Override
	public Object run() throws ZuulException {
		logger.info("证明下进来过这个过滤器~");
		
		RequestContext ctx = RequestContext.getCurrentContext();
		/**
		 * 链路跟踪的traceId放进请求头
		 * 由于Zipkin会在每个Http请求中携带traceId，在此不再往HttpServletRequest中放
		 * 在统一异常处理的框架，或者再统一放返回格式中
		 * Successed
		 * {
		 *   "data": null,
		 *   "traceId": "traceId",
		 *   "resultCode": "200",
		 *   "resutlMsg": "success"
		 * }
		 * 
		 * failed
		 * {
		 *   "errorMsg": null,
		 *   "traceId": "traceId",
		 *   "resultCode": "500",
		 *   "resutlMsg": "failed"
		 * }
		 */
		ctx.addZuulRequestHeader("trace_id", MDC.get("traceId"));
		
		HttpServletRequest request = ctx.getRequest();
		logger.info("TokenFilter {}, {}", request.getMethod(), request.getRequestURL().toString());
        
        /**
         * 1.用户登录时，可将认证完成之后取得的AccessToken放入缓存
         * 2.缓存中以token为键，该用户拥有的资源为值，并设置有效期，前端将所有信息写入浏览器缓存
         * 3.网关可通过token进行鉴权，确定当前用户拥有的权限
         */
		String accessToken = request.getHeader("accessToken");
		accessToken = null == accessToken ? request.getParameter("token") : accessToken;
        if (!StringUtils.isEmpty(accessToken)) {
        	ctx.setSendZuulResponse(true); //对请求进行路由
        	ctx.setResponseStatusCode(200);
        	ctx.set("isSuccess", true);
            return null;
        } else {
        	ctx.setSendZuulResponse(false); //不对其进行路由
        	ctx.setResponseStatusCode(400);
        	ctx.setResponseBody("accessToken is empty");
        	ctx.set("isSuccess", false);
            return null;
        }
		
	}

	/**
	 * 是否执行该过滤器
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器优先级
	 * 数字越小越高
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 过滤器类型
	 */
	@Override
	public String filterType() {
		return Constants.ZUUL_FILTER_TYPE_PRE;
	}

}
