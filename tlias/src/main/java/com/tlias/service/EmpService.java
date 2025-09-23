package com.tlias.service;


import com.tlias.req.newEmpReq;
import com.tlias.req.queryEmpPagedReq;
import com.tlias.resp.QueryEmpResp;
import com.tlias.resp.UpdateEmpResp;

import java.util.List;

public interface EmpService {

    QueryEmpResp queryEmp(queryEmpPagedReq req);

    void saveEmp(newEmpReq req);

    void delete(List<Integer> ids);

    UpdateEmpResp queryEmpById(Integer id);
}
