package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.server.mapper.SalaryMapper;
import com.xxxx.server.pojo.EmployeeVo;
import com.xxxx.server.pojo.MySalaryInfo;
import com.xxxx.server.pojo.Salary;
import com.xxxx.server.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 */

@SuppressWarnings("all")
@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements ISalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public Map<String, Object> listAll(EmployeeVo vo) {
        PageHelper.startPage(vo.getCurrentPage(),vo.getSize());
        List<MySalaryInfo> list = salaryMapper.listAll();
        PageInfo<MySalaryInfo> pageInfo = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("message","成功");
        map.put("total",pageInfo.getTotal());
        map.put("data",list);

        return map;
    }
}
