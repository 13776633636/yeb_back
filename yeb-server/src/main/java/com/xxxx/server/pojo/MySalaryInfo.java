package com.xxxx.server.pojo;

import lombok.Data;

@Data
public class MySalaryInfo  extends Employee{

    private Department department;
    private Salary salary;

}
