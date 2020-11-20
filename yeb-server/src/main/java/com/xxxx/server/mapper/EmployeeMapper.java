package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.EmployeeVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    List<Employee> queryEmpbyName(EmployeeVo employeeVo);

    Integer updateSidById(EmployeeVo vo);

    String maxWorkID();
}
