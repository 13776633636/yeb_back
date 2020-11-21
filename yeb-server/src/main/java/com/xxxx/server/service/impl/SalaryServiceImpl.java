package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.server.mapper.SalaryMapper;
import com.xxxx.server.pojo.*;
import com.xxxx.server.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements ISalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    /**
     * 查询员工套账业务
     * @param respPageBean
     * @return
     */
    @Override
    public Map<String, Object> selectSalaryCfg(RespPageBean respPageBean) {
        //开启分页
        PageHelper.startPage(respPageBean.getCurrentPage(),respPageBean.getSize());

        List<SalarySobCfg> list = salaryMapper.salarySobCfgList();
        System.out.println(list);

        PageInfo<SalarySobCfg> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();
        map.put("data",list);
        map.put("total",pageInfo.getTotal());


        return map;
    }

    /**
     * 查询工资套账业务逻辑
     * @return
     */
    @Override
    public List<Salary> salaryList() {

        List<Salary> list = salaryMapper.selectSalaryList();
        return list;
    }

    @Override
    public Map<String, Object> selectList(RespPageBean respPageBean) {
        return null;
    }
}