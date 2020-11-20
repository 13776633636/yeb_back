package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.MySalaryInfo;
import com.xxxx.server.pojo.Salary;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 */
public interface SalaryMapper extends BaseMapper<Salary> {

    List<MySalaryInfo> listAll();
}
