package com.tlias.service;


import com.tlias.pojo.Emp;
import com.tlias.req.newEmpReq;
import com.tlias.req.queryEmpPagedReq;
import com.tlias.resp.QueryEmpResp;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    QueryEmpResp queryEmp(queryEmpPagedReq req);

    void saveEmp(newEmpReq req);

    void delete(List<Integer> ids);
}
