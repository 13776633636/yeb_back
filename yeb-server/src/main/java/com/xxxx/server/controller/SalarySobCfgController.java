package com.xxxx.server.controller;

import com.xxxx.server.pojo.EmployeeVo;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Salary;
import com.xxxx.server.service.IEmployeeService;
import com.xxxx.server.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 员工账套
 *
 * @author zhoubin
 * @since 1.0.0
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class SalarySobCfgController {

    @Autowired
    private ISalaryService salaryService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/")
    public Map<String, Object> listAllSal(EmployeeVo vo){

        Map<String, Object> list = salaryService.listAll(vo);
        return list;
    }
    @PutMapping("/")
    public RespBean updateSalary(EmployeeVo vo){
        if(employeeService.updateSidById(vo)){
            return RespBean.success("");
        }
        return RespBean.success("更新失败");
    }



    @GetMapping("salaries")
    public List<Salary> querySal(){
        List<Salary> list = salaryService.list();
        return list;
    }



}