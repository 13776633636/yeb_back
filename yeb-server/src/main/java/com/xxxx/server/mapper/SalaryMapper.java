package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Salary;
import com.xxxx.server.pojo.SalarySobCfg;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 */
public interface SalaryMapper extends BaseMapper<Salary> {


    /*List<Emm> selectAll();*/
    List<SalarySobCfg> salarySobCfgList();

    List<Salary> selectSalaryList();
}
