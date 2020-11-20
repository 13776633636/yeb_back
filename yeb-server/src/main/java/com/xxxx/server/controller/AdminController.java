package com.xxxx.server.controller;


import com.xxxx.server.pojo.Admin;
import com.xxxx.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    /*@GetMapping("/")
    public  Map<String, Object> list(String keywords){
        List<Admin> list = adminService.queryBYName(keywords);
        System.out.println(list);
        Map<String, Object>map =new HashMap<>();
        map.put( "admins",list);
        return map;
    }*/
    @GetMapping("/")
    public List<Admin> list(){
        List<Admin> list = adminService.list();


        return list;
    }
}
