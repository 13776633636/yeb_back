package com.xxxx.server.controller;

import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 个人中心
 *
 * @author zhoubin
 * @since 1.0.0
 */
@RequestMapping("/admin/info")
@RestController
public class AdminInfoController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("/")
    public List<Admin> adminList() {
        List<Admin> list = adminService.list();
        return list;
    }

    @PostMapping("/")
    public RespBean addAdmin(@RequestBody Admin admin) {
        if (adminService.save(admin)) {
            return RespBean.success("添加成功");
        }
        return RespBean.success("添加失败");
    }

    @PutMapping("/")
    public RespBean updateAdmin(@RequestBody Admin admin){
            if (adminService.updateById(admin)) {
                return RespBean.success("修改成功");
            }
        return RespBean.success("修改失败");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@PathVariable("id") Integer id){
        if (adminService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }


}