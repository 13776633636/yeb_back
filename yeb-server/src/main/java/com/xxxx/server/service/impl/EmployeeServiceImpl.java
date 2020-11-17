package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.server.mapper.EmployeeMapper;
import com.xxxx.server.mapper.MailLogMapper;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.EmployeeVo;
import com.xxxx.server.service.IEmployeeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
@SuppressWarnings("all")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;//注入EmployeeMapper

	@Autowired
	private RabbitTemplate rabbitTemplate;//注入RabbitTemplate用来实现消息队列
	@Autowired
	private MailLogMapper mailLogMapper;//注入MailLogMapper用来实现邮件功能

	@Override
	public Map<String, Object>  queryEmpbyName(EmployeeVo employeeVo) {
		//查询emp返回emp数组
		PageHelper.startPage(employeeVo.getCurrentPage(),employeeVo.getSize());
		List<Employee>list = employeeMapper.queryEmpbyName(employeeVo);
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		Map<String, Object> map = new HashMap<>();
		map.put("code",200);
		map.put("msg","success");
		map.put("count", pageInfo.getTotal());
		map.put("data",list);
		System.out.println(map);



		/*
		*  //使用 pageHelper 帮我们处理了总记录数
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<Role> list = roleDao.list(vo);
        System.out.println(list);
        PageInfo<Role> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count", pageInfo.getTotal());
        map.put("data",list);
        System.out.println(map);
		* */



		return map;
	}
}
