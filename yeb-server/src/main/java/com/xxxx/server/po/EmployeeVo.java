package com.xxxx.server.po;

import com.xxxx.server.base.BaseQuery;
import com.xxxx.server.pojo.Salary;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
/*@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)*/
public class EmployeeVo extends BaseQuery {

   private Integer currentPage;
   private Integer size;
   private String name;
   private String politicId;
   private String nationId;
   private String posId;
   private String jobLevelId;
   private String engageForm;
   private String departmentId;
   private String beginDateScope;


  /* public Object getCurrentPage() {
      return "";
   }

   public Object getSize() {
      return "";
   }*/
}
