package com.xxxx.server.controller;


import com.xxxx.server.pojo.EmployeeVo;
import com.xxxx.server.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;


    @RequestMapping("/basic")
    public  Map<String, Object> basic(EmployeeVo employeeVo){
        //System.out.println("haha ");测试请求：成功输出haha
        //System.out.println(employee);
        employeeVo.getName();

        Map<String, Object> map = iEmployeeService.queryEmpbyName(employeeVo);

        return map;
    }


}
