package com.xxxx.server.controller;


import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.xxxx.server.mapper.EmployeeMapper;
import com.xxxx.server.pojo.*;
import com.xxxx.server.service.IEmployeeService;
import com.xxxx.server.service.impl.*;
import com.xxxx.server.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhoubin
 */
@SuppressWarnings("all")
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    //注入民族
    @Resource
    private NationServiceImpl nationService;

    //注入job等级
    @Resource
    private JoblevelServiceImpl joblevelService;

    //注入政治状态
    @Resource
    private PoliticsStatusServiceImpl politicsStatusService;

    //注入职位
    @Resource
    private PositionServiceImpl positionService;

    //注入职位
    @Resource
    private DepartmentServiceImpl departmentService;

    /*
     *查询职位
     *
     * */
    @GetMapping("/deps")
    public List<Department> departmentList() {
        return departmentService.list();
    }

    @GetMapping("/positions")
    public List<Position> positionList() {
        return positionService.list();
    }

    @GetMapping("/politicsstatus")
    public List<PoliticsStatus> politicsStatusList() {
        return politicsStatusService.list();
    }

    /*
     * 查询所有joblevels职称
     * */
    @GetMapping("/joblevels")
    public List<Joblevel> selectJoblevels() {
        return joblevelService.list();
    }

    /*
     * 查询出所有民族
     * */
    @RequestMapping("/nations")
    @ResponseBody
    public List<Nation> selectNations() {
        return nationService.selectNation();
    }


    @GetMapping("/")
    public Map<String, Object> basic(EmployeeVo employeeVo) {

        Map<String, Object> map = iEmployeeService.queryEmpbyName(employeeVo);

        return map;
    }

    @PostMapping("")
    public RespBean addEmployee(@RequestBody Employee employee) {
        if (iEmployeeService.save1(employee)) {
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateEmployee(@RequestBody Employee employee) {
        if (iEmployeeService.updateById(employee)) {
            return RespBean.success("更新成功");

        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmploy(@PathVariable("id") String id) {
        if (iEmployeeService.removeById(id)) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteEmployees(Integer[] ids) {
        if (iEmployeeService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @GetMapping("/maxWorkID")
    public Map<String, Object> maxWorkID() {
        Map<String, Object> maxWorkID = iEmployeeService.maxWorkID();
        return maxWorkID;
    }
    /* @GetMapping("/export")
    public Map<String, Object> export(){
        Map<String, Object>  maxWorkID = iEmployeeService.maxWorkID();
        return maxWorkID;
    }*/

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/export")
    public void getExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //得到所有员工信息列表
        EmployeeVo employeeVo = new EmployeeVo();
        final List<Employee> list =employeeMapper.queryEmpbyName(employeeVo);
        System.out.println(list);
        //导出工具类
        try {
            ExcelUtils.exportExcel(list,"员工信息表","员工信息表", Employee.class,"员工信息表",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/import")
    public void excelInput(@RequestParam("file") MultipartFile file) throws Exception {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<Employee> list = ExcelUtils.importExcel(file.getInputStream(), Employee.class, params);
        //导入工具类，得到的数据放入list集合中
        //List<Employee> list = ExcelUtils.importExcel(file, Employee.class,);
        //批量插入
        iEmployeeService.saveBatch(list);
    }
}
