package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.resp.QueryEmpResp;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result queryEmpPaged(@RequestParam(defaultValue = "1") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                String name, Integer gender,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                                @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
        log.info("queryEmp, pageNo:{}, pageSize:{}, name:{}, gender:{}, begin:{}, end:{}", pageNo, pageSize, name,
                gender, begin, end);
        QueryEmpResp resp = empService.queryEmp(pageNo, pageSize, name, gender, begin, end);
        log.info("queryEmp, resp:{}", resp);
        return Result.success(resp);
    }

}
