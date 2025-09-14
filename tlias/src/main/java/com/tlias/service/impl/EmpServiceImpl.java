package com.tlias.service.impl;

import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.resp.QueryEmpPagedResp;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public QueryEmpPagedResp queryEmpPaged(Integer pageNo, Integer pageSize) {
        Integer offset = (pageNo - 1) * pageSize;
        List<Emp> empList = empMapper.queryEmpPaged(offset, pageSize);
        Integer total = empMapper.getCount();
        QueryEmpPagedResp resp = new QueryEmpPagedResp();
        resp.setRows(empList);
        resp.setTotal(total);
        return resp;
    }
}
