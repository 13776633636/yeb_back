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
        Integer isParent = departmentService.queryById(parentId.toString());
        if (isParent == 0){
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
        Integer isParent = departmentService.queryById(id);
       AssertUtil.isTrue(isParent ==1 ,"部门下有子部门，不能删除",401);

        if (departmentService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败!");
    }

}
