/*
package com.xxxx.server.utils;


import com.xxxx.server.pojo.Student;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


*/
/**
 * 测试文件导出
 * @author liuyazhuang
 *
 *//*

public class Test {

    public static void main(String[] args) throws Exception{
        ExportExcelUtils<Student> util = new ExportExcelUtils<Student>();
        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(111,"张三asdf","男"));
            list.add(new Student(111,"李四asd","男"));
            list.add(new Student(111,"王五","女"));
        }
        String[] columnNames = { "ID", "姓名", "性别" };
        util.exportExcel("用户导出", columnNames, list, new FileOutputStream("E:/test.xls"), ExportExcelUtils.EXCEL_FILE_2003);
    }
}*/
