package org.zj.spring.cloud.eurekaapigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 *  AccessFilter : 网关请求过滤器
 * @author mrzhang
 *
 */
public class AccessFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);
	
	/**
	 * 过滤器执行逻辑
	 */
	@Override
	public Object run() throws ZuulException {
		// 获取Zuul 网关上下文
		RequestContext currentContext = RequestContext.getCurrentContext();
		// 获取当前请求
		HttpServletRequest request = currentContext.getRequest();
		
		Object token = request.getParameter("token");
		if(token == null) {
			logger.warn("you are not access !, token is null");
			//不进行路由
			currentContext.setSendZuulResponse(false);
			//执行返回本次请求为 401
			currentContext.setResponseStatusCode(401);
			return null;
		}
		
		logger.info("access!,token is not null");
		return null;
	}
	
	/**
	 *  判断该过滤器是否执行，返回true 执行
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	/**
	 * 确定过滤器类型，pre 值 让请求在路由前进行拦截
	 */
	@Override
	public String filterType() {
		return "pre";
	}
	/**
	 * 过滤器的顺序，在请求的某个时刻存在多个过滤器，需要按照方法的返回值来依次执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
