package com.tlias.service;


import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpGenderStatistic;
import com.tlias.pojo.LoginInfo;
import com.tlias.req.NewEmpReq;
import com.tlias.req.QueryEmpPagedReq;
import com.tlias.req.UpdateEmpReq;
import com.tlias.resp.QueryEmpResp;
import com.tlias.resp.UpdateEmpResp;

import java.util.List;

public interface EmpService {

    QueryEmpResp queryEmp(QueryEmpPagedReq req);

    void saveEmp(NewEmpReq req);

    void delete(List<Integer> ids);

    UpdateEmpResp queryEmpById(Integer id);

    void updateEmp(UpdateEmpReq req);

    List<EmpGenderStatistic> empGenderStatistic();

    LoginInfo login(Emp emp);
}
