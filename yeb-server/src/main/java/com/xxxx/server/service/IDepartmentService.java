package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Department;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 */
public interface IDepartmentService extends IService<Department> {


   List<Department> listAll();

    Integer queryById(String id);

    void updateIsParent(Integer parentId);
}
