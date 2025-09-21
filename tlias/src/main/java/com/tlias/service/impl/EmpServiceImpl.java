package com.tlias.service.impl;

import com.tlias.mapper.EmpExprMapper;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpExpr;
import com.tlias.req.newEmpReq;
import com.tlias.req.queryEmpPagedReq;
import com.tlias.resp.QueryEmpResp;
import com.tlias.service.EmpService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public QueryEmpResp queryEmp(queryEmpPagedReq req) {
        Integer offset = (req.getPageNo() - 1) * req.getPageSize();
        List<Emp> empList = empMapper.queryEmp(req.getName(), req.getGender(), req.getBegin(), req.getEnd(), offset, req.getPageSize());
        Integer total = empMapper.getCount(req.getName(), req.getGender(), req.getBegin(), req.getEnd());
        QueryEmpResp resp = new QueryEmpResp();
        resp.setRows(empList);
        resp.setTotal(total);
        return resp;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveEmp(newEmpReq req) {
        Emp emp = req.getEmp();
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insertEmp(emp);

        List<EmpExpr> empExprs = req.getEmpExprs();
        if(!CollectionUtils.isEmpty(empExprs)){
            empExprs.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.batchInsertEmpExpr(empExprs);
        }
    }
}
