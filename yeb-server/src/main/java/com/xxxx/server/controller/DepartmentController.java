package com.xxxx.server.controller;


import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IDepartmentService;
import com.xxxx.server.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
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
        AssertUtil.isTrue(StringUtils.isBlank(department.getName()),"部门名字为空",401);
        Integer parentId = department.getParentId();
        Department parentDepartment = departmentService.queryById(parentId.toString());//查出父亲
        if (parentDepartment.getParent() == false){//如父亲的isparent为false ,则需要改为true
            departmentService.updateIsParent(parentId);
        }
        //AssertUtil.isTrue();

        if (departmentService.save(department)) {
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteDepartment(@PathVariable("id") String id){

        Department department = departmentService.queryById(id);//需要删除的对象
        //查出它的父亲
        Department parentDepartment = departmentService.queryById(department.getParentId().toString());

        AssertUtil.isTrue(department.getParent() ,"部门下有子部门，不能删除",401);

        if (departmentService.removeById(id)){
            //查出parentId集合
            List<Integer> list = departmentService.queryParentIdList();
            boolean contains = list.contains(parentDepartment.getId());
            if(contains == false){//没有子了
                //把isparent改为false
                departmentService.updateIsParentByid(parentDepartment.getId());
            }
            return RespBean.success("删除成功");

        }
        return RespBean.success("删除失败!");
    }

}
