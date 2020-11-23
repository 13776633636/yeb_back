package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Department;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    List<Department> listAll();

    Department queryById(String id);

    void updateIsParent(Integer parentId);


    List<Integer> queryParentIdList();

    void updateIsParentByid(Integer id);
}
