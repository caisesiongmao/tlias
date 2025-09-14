package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.resp.QueryEmpPagedResp;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/queryEmpPaged")
    public Result queryEmpPaged(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("queryEmpByPage, pageNo:{}, pageSize:{}", pageNo, pageSize);
        QueryEmpPagedResp resp = empService.queryEmpPaged(pageNo, pageSize);
        log.info("queryEmpByPage, resp:{}", resp);
        return Result.success(resp);
    }

}
