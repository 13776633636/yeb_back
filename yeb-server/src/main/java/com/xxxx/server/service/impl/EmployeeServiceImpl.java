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
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    private RedisTemplate redisTemplate;

	@Override
	public Map<String, Object>  queryEmpbyName(EmployeeVo employeeVo) {
        Map<String, Object> map = new HashMap<>();//最终返回的hash
        //HashOperations hash = redisTemplate.opsForHash();
        //Map employees = hash.entries("Employees");//获取所有的hash


        //开启分页
        PageHelper.startPage(employeeVo.getCurrentPage(),employeeVo.getSize());
        List<Employee> list= employeeMapper.queryEmpbyName(employeeVo);
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		pageInfo = new PageInfo<>(list);
		map.put("code",200);
		map.put("msg","success");
		map.put("total", pageInfo.getTotal());
		map.put("data",list);

        /*if(employees.size() == 0){//缓存中没有，去数据库查询，并设置缓存
            //查询emp返回list集合,并设置到redis缓存中
           List<Employee> list= employeeMapper.queryEmpbyName(employeeVo);
            System.out.println(list.size());
            for (Employee e:list) {
                hash.put("Employees",e.getName(),e);//便利加入到redis中
            }
            pageInfo = new PageInfo<>(list);
            map.put("code",200);
            map.put("msg","success");
            map.put("count", pageInfo.getTotal());
            map.put("data",list);
        }else{//缓存中有
            String name = employeeVo.getName();//前段传的name
            if(name == "" | name == null ){
                //name不存在则，查询全部缓存并返回
                Set employees1 = employees.entrySet();
                pageInfo = new PageInfo<>(new ArrayList<>(employees1));
                map.put("code",200);
                map.put("msg","success");
                map.put("count", pageInfo.getTotal());
                map.put("data",employees1);
            }else{
                Object o = ((HashMap) employees).get("name");//获取hash中的某个key
                map.put("code",200);
                map.put("msg","success");
                map.put("count", 1);
                map.put("data",o);
            }

        }*/
        return map;

	}
}
