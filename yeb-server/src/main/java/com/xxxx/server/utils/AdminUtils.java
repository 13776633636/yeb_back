package com.xxxx.server.utils;

import com.xxxx.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 操作员工具类
 *
 * @author zhoubin
 * @since 1.0.0
 */
public class AdminUtils {

	/**
	 * 获取当前登录操作员
	 *
	 * @return
	 */
	public static Admin getCurrentAdmin() {
		Admin admin = (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return admin;
	}

}