package org.zj.spring.cloud.eurekaapigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 *  AccessFilter : �������������
 * @author mrzhang
 *
 */
public class AccessFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);
	
	/**
	 * ������ִ���߼�
	 */
	@Override
	public Object run() throws ZuulException {
		// ��ȡZuul ����������
		RequestContext currentContext = RequestContext.getCurrentContext();
		// ��ȡ��ǰ����
		HttpServletRequest request = currentContext.getRequest();
		
		Object token = request.getParameter("token");
		if(token == null) {
			logger.warn("you are not access !, token is null");
			//������·��
			currentContext.setSendZuulResponse(false);
			//ִ�з��ر�������Ϊ 401
			currentContext.setResponseStatusCode(401);
			return null;
		}
		
		logger.info("access!,token is not null");
		return null;
	}
	
	/**
	 *  �жϸù������Ƿ�ִ�У�����true ִ��
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	/**
	 * ȷ�����������ͣ�pre ֵ ��������·��ǰ��������
	 */
	@Override
	public String filterType() {
		return "pre";
	}
	/**
	 * ��������˳���������ĳ��ʱ�̴��ڶ������������Ҫ���շ����ķ���ֵ������ִ��
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
