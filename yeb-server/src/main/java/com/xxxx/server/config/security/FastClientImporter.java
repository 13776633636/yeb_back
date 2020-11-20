package com.xxxx.server.config.security;


import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
@Configuration
@Import(FdfsClientConfig.class)//导入FastDFS-Client组件
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING) //解决jmx重复注册bean的问
/*
* fastdfs配置类
*
* */

public class FastClientImporter  {

}