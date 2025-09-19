package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.req.newEmpReq;
import com.tlias.req.queryEmpPagedReq;
import com.tlias.resp.QueryEmpResp;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result queryEmpPaged(queryEmpPagedReq req) {
        log.info("queryEmp, pageNo:{}, pageSize:{}, name:{}, gender:{}, begin:{}, end:{}", req.getPageNo(), req.getPageSize(), req.getName(),
                req.getGender(), req.getBegin(), req.getEnd());
        QueryEmpResp resp = empService.queryEmp(req);
        log.info("queryEmp, resp:{}", resp);
        return Result.success(resp);
    }

    @PostMapping
    public Result saveEmp(@RequestBody newEmpReq req) {
        log.info("saveEmp, req:{}", req);
        empService.saveEmp(req);
        return Result.success(null);
    }

}
