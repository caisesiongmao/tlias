package com.tlias.service;


import com.tlias.resp.QueryEmpPagedResp;

public interface EmpService {

    QueryEmpPagedResp queryEmpPaged(Integer pageNo, Integer pageSize);
}
