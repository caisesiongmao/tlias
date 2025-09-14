package com.tlias.service;


import com.tlias.resp.QueryEmpResp;

import java.time.LocalDate;

public interface EmpService {

    QueryEmpResp queryEmp(Integer pageNo, Integer pageSize, String name,
                          Integer gender, LocalDate begin, LocalDate end);
}
