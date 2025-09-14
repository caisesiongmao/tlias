package com.tlias.service.impl;

import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.resp.QueryEmpResp;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public QueryEmpResp queryEmp(Integer pageNo, Integer pageSize, String name,
                                 Integer gender, LocalDate begin, LocalDate end) {
        Integer offset = (pageNo - 1) * pageSize;
        List<Emp> empList = empMapper.queryEmp(name, gender, begin, end, offset, pageSize);
        Integer total = empMapper.getCount();
        QueryEmpResp resp = new QueryEmpResp();
        resp.setRows(empList);
        resp.setTotal(total);
        return resp;
    }
}
