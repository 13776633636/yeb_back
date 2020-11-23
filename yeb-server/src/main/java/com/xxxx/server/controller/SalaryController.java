package com.xxxx.server.controller;


import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Salary;
import com.xxxx.server.service.ISalaryService;
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
@RequestMapping("/salary/sob")
public class SalaryController {

    @Autowired
    private ISalaryService salaryService;


    @GetMapping("/")
    public List<Salary> listAll() {
        List<Salary> list = salaryService.list();
        return list;
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        if (salaryService.save(salary)) {
            return RespBean.success("添加成功");
        }
        return RespBean.success("添加失败");
    }

    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary) {
        if (salaryService.updateById(salary)) {
            return RespBean.success("添加成功");
        }
        return RespBean.success("添加失败");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteSalary(@PathVariable("id") Integer id){
        if(salaryService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }
}