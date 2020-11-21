package com.xxxx.server.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SalarySobCfg implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String workID;
    private String email;
    private String phone;
    private Integer departmentId;
    private String departmentName;

}
