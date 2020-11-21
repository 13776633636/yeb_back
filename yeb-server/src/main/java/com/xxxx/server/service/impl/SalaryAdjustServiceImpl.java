package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.SalaryAdjustMapper;
import com.xxxx.server.mapper.SalaryMapper;
import com.xxxx.server.pojo.Emm;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.SalaryAdjust;
import com.xxxx.server.service.ISalaryAdjustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 */
@Service
public class SalaryAdjustServiceImpl extends ServiceImpl<SalaryAdjustMapper, SalaryAdjust> implements ISalaryAdjustService {
    @Override
    public List<Employee> selectList() {
        return null;
    }
    /*@Autowired
    private SalaryAdjustMapper salaryAdjustMapper;

    @Override
    public List<Employee> selectEmployee() {
        return null;*/
    }

