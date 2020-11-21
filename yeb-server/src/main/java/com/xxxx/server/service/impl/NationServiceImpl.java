package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.NationMapper;
import com.xxxx.server.pojo.Nation;
import com.xxxx.server.service.INationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

    @Resource
    private NationMapper nationMapper;


    public List<Nation> selectNation() {
        List<Nation>list = nationMapper.selectNation();

        return list;
    }
}
