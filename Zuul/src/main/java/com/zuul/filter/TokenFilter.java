package com.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		
		logger.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        String accessToken = request.getHeader("accessToken");
        accessToken = null == accessToken ? request.getParameter("token") : accessToken;
        
        /**
         * TODO
         * 1.用户登录时，可将认证完成之后取得的AccessToken放入缓存
         * 2.缓存中以token为键，该用户拥有的资源为值，并设置有效期，前端将所有信息写入浏览器缓存
         * 3.网关可通过token进行鉴权，确定当前用户拥有的权限
         */

        if (!StringUtils.isEmpty(accessToken)) {
        	requestContext.setSendZuulResponse(true); //对请求进行路由
        	requestContext.setResponseStatusCode(200);
        	requestContext.set("isSuccess", true);
            return null;
        } else {
        	requestContext.setSendZuulResponse(false); //不对其进行路由
        	requestContext.setResponseStatusCode(400);
        	requestContext.setResponseBody("accessToken is empty");
            requestContext.set("isSuccess", false);
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
