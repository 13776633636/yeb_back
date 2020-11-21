package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.SalaryAdjust;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 */

public interface ISalaryAdjustService extends IService<SalaryAdjust> {

    List<Employee> selectList();
}
