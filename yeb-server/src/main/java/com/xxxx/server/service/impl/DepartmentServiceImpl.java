package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.DepartmentMapper;
import com.xxxx.server.pojo.Department;
import com.xxxx.server.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhoubin
 */
@SuppressWarnings("all")
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> listAll() {
        List<Department> resultList = new ArrayList<>();
        List<Department> list = departmentMapper.listAll();


        Map<Integer, Department> map = new HashMap<>();

        for (Department dep : list) {
            int id = dep.getId();
            List<Department> child = new ArrayList<>();
            for (Department deptChild : list) {
                if (id == deptChild.getParentId()){
                    child.add(deptChild);
                }
            }
            dep.setChildren(child);
            if (dep.getParentId()<0){
                resultList.add(dep);
            }
        }


        return resultList;
    }

    @Override
    public Department queryById(String id) {
        Department isParent = departmentMapper.queryById(id);
        return isParent;
    }

    @Override
    public void updateIsParent(Integer parentId) {
        departmentMapper.updateIsParent(parentId);
    }

    @Override
    public List<Integer> queryParentIdList() {

        List<Integer> list = departmentMapper.queryParentIdList();
        return list;
    }

    @Override
    public void updateIsParentByid(Integer id) {
        departmentMapper.updateIsParentByid(id);
    }
}
