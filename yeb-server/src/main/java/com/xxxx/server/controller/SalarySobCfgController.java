package com.xxxx.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工账套
 *
 * @author zhoubin
 * @since 1.0.0
 */
@RestController
@RequestMapping("/salary")
public class SalarySobCfgController {

    @Autowired


    @RequestMapping("/sobcfg")
    public String sobcfg(){


        return "";
    }

}