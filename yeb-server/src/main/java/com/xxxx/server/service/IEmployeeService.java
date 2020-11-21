package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.po.EmployeeVo;
import com.xxxx.server.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 */
public interface IEmployeeService extends IService<Employee> {


    Map<String, Object> selectAllList(EmployeeVo vo);
    void delectUser(Integer id);
    List<Position> selectPosition();
    List<Joblevel> selectJobLevels();
    List<Nation> selectNation();
    List<PoliticsStatus> selectPoliticsStatus();
    List<Department> selectDepartment();

}
