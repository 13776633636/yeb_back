package com.xxxx.server.controller;

import com.xxxx.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	private IAdminService adminService;


}