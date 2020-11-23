package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.po.EmployeeVo;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.EmployeeVo;

import java.util.List;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /*List<Employee> selectList(EmployeeVo vo);*/

    List<Employee> selectAllList(EmployeeVo vo);
    List<Employee> queryEmpbyName(EmployeeVo employeeVo);

    Integer updateSidById(EmployeeVo vo);

    String maxWorkID();

    int save1(Employee employee);

    Employee selectEmployeeById(Integer id);


}
