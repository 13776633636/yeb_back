package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.server.mapper.EmployeeMapper;
import com.xxxx.server.mapper.MailLogMapper;
import com.xxxx.server.po.EmployeeVo;
import com.xxxx.server.pojo.*;
import com.xxxx.server.service.IEmployeeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

}
