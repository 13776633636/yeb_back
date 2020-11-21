package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.EmployeeVo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 */
public interface IEmployeeService extends IService<Employee> {


    Map<String, Object> queryEmpbyName(EmployeeVo employeeVo);

    boolean updateSidById(EmployeeVo vo);

    Map<String, Object>  maxWorkID();

    boolean save1(Employee employee);
}
