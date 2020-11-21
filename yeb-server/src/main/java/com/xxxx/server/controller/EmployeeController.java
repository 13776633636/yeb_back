package com.xxxx.server.controller;


import com.xxxx.server.po.EmployeeVo;
import com.xxxx.server.pojo.*;
import com.xxxx.server.service.IEmployeeEcService;
import com.xxxx.server.service.IEmployeeService;
import com.xxxx.server.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //注入service
  /* @Resource
    private EmployeeServiceImpl employeeService;*/

   //注入职位
    /*@Resource
    private */
    @Autowired
    private IEmployeeService iEmployeeService;
    //进入查询用户列表功能
    @RequestMapping("/basic")
    public Map<String,Object> selectAllList(EmployeeVo vo){
       Map<String,Object> map= iEmployeeService.selectAllList(vo);
        return map;
    }


   /* //查询职称
    @GetMapping("/joblevels")
    public List<Joblevel>selectJobLevels(){
        return iEmployeeService.selectJobLevels();
    }


    //查询民族
    @GetMapping("/nations")
    public List<Nation> selectnations(){
        return iEmployeeService.selectNation();
    }

    //查询政治面貌
    @GetMapping("/politicsstatus")
    public List<PoliticsStatus> selectpoliticsstatus(){
        return iEmployeeService.selectPoliticsStatus();
    }

    //查询所属部门
    @GetMapping("/deps")
    public List<Department> selectDepartment(){
        return iEmployeeService.selectDepartment();
    }


    //查询职位
    @GetMapping("/positions")
    public List<Position> selectPositions(){
        return iEmployeeService.selectPosition();
    }
    //删除单个
    @DeleteMapping("/{id}")
    public RespBean delectUser(@PathVariable Integer id){
        iEmployeeService.delectUser(id);
        RespBean respBean = new RespBean();
        return respBean.success("删除好了！");
    }
*/

}
