package com.xxxx.server.controller;

import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IAdminService;
import com.xxxx.server.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 个人中心
 *
 * @author zhoubin
 * @since 1.0.0
 */
@RequestMapping("/admin")
@RestController
public class AdminInfoController {

    //注入adminserver
    @Autowired
    private IAdminService adminService;

    /*
     * 更新用户信息，手机号码，电话号码等
     * */
    @PutMapping("/info")
    public RespBean updateAdmin(@RequestBody Admin admin) {
        int length = admin.getPhone().length();
        AssertUtil.isTrue(length > 11, "手机号码长度不合法", 500);

        if (adminService.updateById(admin)) {
            return RespBean.success("修改成功");
        }
        return RespBean.error("修改失败");
    }




}