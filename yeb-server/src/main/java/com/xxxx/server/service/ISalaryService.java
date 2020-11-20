package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.EmployeeVo;
import com.xxxx.server.pojo.Salary;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 */
public interface ISalaryService extends IService<Salary> {

    Map<String, Object> listAll(EmployeeVo vo);

}
