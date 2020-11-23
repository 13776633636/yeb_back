package com.xxxx.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Salary;
import com.xxxx.server.service.impl.SalaryServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.executor.SimpleExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    private SalaryServiceImpl salaryService;

    @GetMapping
    public List<Salary> selectSalary() {

        List<Salary> list = salaryService.salaryList();

        return list;
    }


    /*添加工资账套*/

    @ApiOperation("添加工资套账")
    @PostMapping
    public RespBean addSalary(@RequestBody Salary salary) {

        boolean save = salaryService.save(salary);
        if (save) {
            return RespBean.success("添加成功", salary);
        } else {
            return RespBean.error("添加失败");
        }

    }

    @ApiOperation("修改工资套账")
    @PutMapping
    public RespBean updateSalary(@RequestBody Salary salary) {
        boolean update = salaryService.updateById(salary);
        if (update) {
            return RespBean.success("修改成功", salary);
        } else {
            return RespBean.error("修改失败");
        }
    }

    @ApiOperation("删除工资套账")
    @DeleteMapping("/{id}")
    public RespBean deleteSalary(@PathVariable Integer id) {

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
        boolean success = salaryService.remove(new QueryWrapper<Salary>().eq("id", id));
        if (success) {
            return RespBean.success("删除成功", id);
        } else {
            return RespBean.error("删除失败");
        }
        /*excutor
        * queryCursor
        * SimpleExcutor executor =
        *
        * OncePerRequestFilter
        * OpenEntityManagerInViewFilter
        * */
//        SimpleExcutor executor = new SimpleExecutor(configuraton,jdbcTranscation);
//        List<Object> list =executor.doQuery(ms,10,DEFAULT,


//                )


    }
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
