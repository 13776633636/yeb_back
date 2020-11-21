package com.xxxx.server.controller;


import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhoubin
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getDepartmentList() {
        List<Department> list = departmentService.listAll();
        System.out.println(list);
        return list;
    }

    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department department) {

        if (departmentService.save(department)) {
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteDepartment(@PathVariable("id") String id){
        if (departmentService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }

}
