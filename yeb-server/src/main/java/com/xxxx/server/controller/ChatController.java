package com.xxxx.server.controller;

import com.xxxx.server.pojo.Admin;
import com.xxxx.server.service.IAdminService;
import com.xxxx.server.utils.AdminUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 在线聊天
 *
 * @author zhoubin
 * @since 1.0.0
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	private IAdminService adminService;

	@GetMapping("/admin")
	public List<Admin> chat11112123(){


		//查询当前用户
		final Admin currentAdmin = AdminUtils.getCurrentAdmin();
		///设置密码为空
		currentAdmin.setPassword(null);
		//查询所有用户并移除自己
		final List<Admin> admins = adminService.list();
		Admin adminTemp=null;
		for (Admin admin : admins){
			if (admin.getId() == currentAdmin.getId()){
				adminTemp=admin;
			}
			admin.setRoles(adminService.getRoles(admin.getId()));
		}
		admins.remove(adminTemp);

		return admins;

	}
}