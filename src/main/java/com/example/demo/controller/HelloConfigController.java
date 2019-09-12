package com.example.demo.controller;

import com.example.demo.entity.TestUser;
import com.example.demo.entity.UserBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({UserBody.class})
public class HelloConfigController {
    @Value("${offcn_ip}")
    private String offcn_ip;

    @Value("${offcn_port}")
    private String offcn_port;

    @Autowired
    UserBody userbody;

    @Autowired
    TestUser testUser;

    @GetMapping("/getvalue")
    public String getValue() {
        return "ip:"+offcn_ip+" port:"+offcn_port;
    }

    @GetMapping("/getUser")
    public String getUser(){
        return userbody.toString();
    }

    @GetMapping("/gettestuser")
    public String gettestUser() {
        return testUser.toString();
    }
}
