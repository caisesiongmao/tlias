package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.LoginInfo;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("emp:{} login", emp);
        LoginInfo loginInfo = empService.login(emp);
        log.info("login info:{}",loginInfo);
        return Result.success(loginInfo);
    }
}
