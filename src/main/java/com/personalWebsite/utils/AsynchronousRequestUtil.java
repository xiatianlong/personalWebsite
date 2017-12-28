package com.personalWebsite.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 异步请求工具类
 * Created by xiatianlong on 2017/12/28.
 */
public class AsynchronousRequestUtil {

	/**
	 * 异步请求在报头中设定的key
	 */
	public final static String ASYNCHRONOUS_REQUEST_HEADER_KEY = "x-requested-with";

	/**
	 * 异步请求在报头中设定的value
	 */
	public final static String ASYNCHRONOUS_REQUEST = "XMLHttpRequest";


	/**
	 * 是否是异步请求
	 * 
	 * @param request 客户端请求
	 * @return 是否异步
	 */
	public static boolean isAsynchronousRequest(HttpServletRequest request) {
		return ASYNCHRONOUS_REQUEST.equalsIgnoreCase(request.getHeader(ASYNCHRONOUS_REQUEST_HEADER_KEY));
	}

}
