package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Emm;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.RespPageBean;
import com.xxxx.server.pojo.Salary;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 */
public interface ISalaryService extends IService<Salary> {


    Map<String,Object> selectSalaryCfg(RespPageBean respPageBean);

    List<Salary> salaryList();

    Map<String, Object> selectList(RespPageBean respPageBean);
}
