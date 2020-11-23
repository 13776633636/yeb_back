
package com.xxxx.server.controller;


import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;
import com.xxxx.server.service.IAdminRoleService;
import com.xxxx.server.service.IAdminService;
import com.xxxx.server.service.IRoleService;
import com.xxxx.server.utils.AdminUtils;
import com.xxxx.server.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 */
@RestController
@RequestMapping("/system")
public class AdminController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IAdminRoleService adminRoleService;


    @PutMapping("/admin")
    public RespBean forbid(@RequestBody Admin admin){
        Admin currentAdmin = AdminUtils.getCurrentAdmin();
        AssertUtil.isTrue(currentAdmin.getId()==admin.getId(),"不能禁用自己哦",401);
        if (adminService.updateById(admin)){
            return RespBean.success("");
        }

        return RespBean.error("修改失败");
    }

    @GetMapping("/admin")
    public List<Admin> list(String keywords){
        List<Admin> list = adminService.listAll(keywords);
        return list;
    }

    @GetMapping("/admin/roles")
    public List<Role> listAllRoles(){
        List<Role> list = roleService.list();
        return list;
    }

    @PutMapping("/admin/role")
    public RespBean updateRole(Integer adminId,Integer[]rids){
        boolean b = adminRoleService.removeById(adminId);

        int rows = adminRoleService.insertRole(adminId ,rids);
        if(rows>0){
            return RespBean.success("修改成功");
        }
       return RespBean.error("修改失败");
    }
    @DeleteMapping("/admin/{id}")
    public RespBean deleteRole(@PathVariable Integer id){
       if (adminService.removeById(id)){
          return RespBean.success("删除成功");
       }
       return RespBean.error("删除失败");
    }
}