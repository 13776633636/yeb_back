package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.AdminRoleMapper;
import com.xxxx.server.pojo.AdminRole;
import com.xxxx.server.service.IAdminRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements IAdminRoleService {


    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Override
    public int insertRole(Integer adminId, Integer[] rids) {
        int rows = adminRoleMapper.insertRole(adminId,rids);
        return rows;
    }
}
