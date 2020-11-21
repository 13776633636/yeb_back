package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.po.EmployeeVo;
import com.xxxx.server.pojo.Employee;

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
}
