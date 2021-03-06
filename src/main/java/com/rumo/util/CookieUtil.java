package com.rumo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * CookieUtil<br/>
 * 创建人:xuchengfei<br/>
 * 时间：2018年4月15日-上午2:15:14 <br/>
 * 
 * @version 1.0.0<br/>
 *
 */
public class CookieUtil {

	// private final static String COOKIE_DOMAIN = ".itbooking.com";
	private final static String COOKIE_NAME = "itbooking_login_token";

	public static String readLoginToken(HttpServletRequest request) {
		Cookie[] cks = request.getCookies();
		if (cks != null) {
			for (Cookie ck : cks) {
				if (StringUtils.equals(ck.getName(), COOKIE_NAME)) {
					return ck.getValue();
				}
			}
		}
		return null;
	}

	public static void writeLoginToken(HttpServletResponse response, String token) {
		Cookie ck = new Cookie(COOKIE_NAME, token);
		// ck.setDomain(COOKIE_DOMAIN);
		ck.setPath("/");// 代表设置在根目录
		ck.setHttpOnly(true);
		// 单位是秒。
		// 如果这个maxage不设置的话，cookie就不会写入硬盘，而是写在内存。只在当前页面有效。
		ck.setMaxAge(60 * 60 * 24 * 7);// 如果是-1，代表永久
		response.addCookie(ck);
	}

	public static void delLoginToken(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cks = request.getCookies();
		if (cks != null) {
			for (Cookie ck : cks) {
				if (StringUtils.equals(ck.getName(), COOKIE_NAME)) {
					// ck.setDomain(COOKIE_DOMAIN);
					ck.setPath("/");
					ck.setMaxAge(0);// 设置成0，代表删除此cookie。
					response.addCookie(ck);
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
	}

}
