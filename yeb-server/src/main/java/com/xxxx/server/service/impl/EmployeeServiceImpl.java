package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.server.mapper.EmployeeMapper;
import com.xxxx.server.mapper.MailLogMapper;
import com.xxxx.server.po.EmployeeVo;
import com.xxxx.server.pojo.*;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.EmployeeVo;
import com.xxxx.server.pojo.MailConstants;
import com.xxxx.server.service.IEmployeeService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

	@Resource
	private EmployeeMapper employeeMapper;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Resource
	private MailLogMapper mailLogMapper;
	@Override
	public Map<String, Object> selectAllList(EmployeeVo vo) {

		//开启分页
		PageHelper.startPage(vo.getCurrentPage(),vo.getSize());
		List<Employee> list=employeeMapper.selectAllList(vo);
		PageInfo<Employee> pageInfo = new PageInfo(list);
		Map<String, Object> map = new HashMap<>();
		/*map.put("code",200);
		map.put("message","");*/
		map.put("total",pageInfo.getTotal());
		map.put("data",pageInfo.getList());
		return map;
	}

	@Override
	public void delectUser(Integer id) {

	}

	@Override
	public List<Position> selectPosition() {
		return null;
	}

	@Override
	public List<Joblevel> selectJobLevels() {
		return null;
	}

	@Override
	public List<Nation> selectNation() {
		return null;
	}

	@Override
	public List<PoliticsStatus> selectPoliticsStatus() {
		return null;
	}

	@Override
	public List<Department> selectDepartment() {
		return null;
	}

	/*@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private MailLogMapper mailLogMapper;*/
    @Autowired
    private EmployeeMapper employeeMapper;//注入EmployeeMapper

    @Autowired
    private RabbitTemplate rabbitTemplate;//注入RabbitTemplate用来实现消息队列
    @Autowired
    private MailLogMapper mailLogMapper;//注入MailLogMapper用来实现邮件功能
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> queryEmpbyName(EmployeeVo employeeVo) {

        if(employeeVo.getName()!=null && !employeeVo.getName().equals("")){
            employeeVo.setCurrentPage(1);
            employeeVo.setSize(10);
        }

        Map<String, Object> map = new HashMap<>();//最终返回的hash


        //开启分页
        PageHelper.startPage(employeeVo.getCurrentPage(), employeeVo.getSize());
        List<Employee> list = employeeMapper.queryEmpbyName(employeeVo);
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
       // pageInfo = new PageInfo<>(list);
        map.put("code", 200);
        map.put("message", "11111111111");
        map.put("total", pageInfo.getTotal());
        map.put("data", list);

		/*
		PageInfo<Employee> pageInfo=null;
		PageHelper.startPage(employeeVo.getCurrentPage(), employeeVo.getSize());
        HashOperations hash = redisTemplate.opsForHash();
        Map employees = hash.entries("Employees_"+employeeVo.getCurrentPage());//获取所有的hash
        if(employees.size() == 0){//缓存中没有，去数据库查询，并设置缓存
            //查询emp返回list集合,并设置到redis缓存中
           List<Employee> list= employeeMapper.queryEmpbyName(employeeVo);
            System.out.println(list.size());
            for (Employee e:list) {
                hash.put("Employees_"+employeeVo.getCurrentPage(),e.getName(),e);//便利加入到redis中
            }
            pageInfo = new PageInfo<>(list);
            map.put("code",200);
            map.put("msg","success");
            map.put("total", pageInfo.getTotal());
            map.put("data",list);
        }else{//缓存中有
            String name = employeeVo.getName();//前段传的name
            if(name == "" | name == null ){
                //name不存在则，查询全部缓存并返回
                Set employees1 = employees.entrySet();
                pageInfo = new PageInfo<>(new ArrayList<>(employees1));
                map.put("code",200);
                map.put("msg","success");
                map.put("total", pageInfo.getTotal());
                map.put("data",employees1);
            }else{
				List<Employee> list = employeeMapper.queryEmpbyName(employeeVo);
                map.put("code",200);
                map.put("msg","success");
                map.put("total", 1);
                map.put("data",list);
            }

        }*/
        return map;

    }

    @Override
    public boolean updateSidById(EmployeeVo vo) {
        Integer row = employeeMapper.updateSidById(vo);
        if (row > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object>  maxWorkID() {

        Map<String, Object> map = new HashMap<>();

        String maxWorkID= employeeMapper.maxWorkID();
        //转成int +1
        Integer newWorkIdInt = Integer.valueOf(maxWorkID) + 1;
        //装成String
        String newWorkId = newWorkIdInt.toString();
        for (int i = 0; i < maxWorkID.length()-newWorkId.length(); i++) {
            newWorkId = "0" + newWorkId;
        }
        map.put("obj",newWorkId);
        return map;


    }

    @Override
    public boolean save1(Employee employee) {
        int row = employeeMapper.save1(employee);
        if (row>0){
            //String email = employee.getEmail();
            Employee newEmp = employeeMapper.selectEmployeeById(employee.getId());
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME,MailConstants.MAIL_ROUTING_KEY_NAME,newEmp,new CorrelationData(UUID.randomUUID().toString()));
            return true;
        }
        return false;
    }
}
