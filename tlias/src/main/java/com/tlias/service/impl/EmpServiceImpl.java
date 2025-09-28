package com.tlias.service.impl;

import com.tlias.mapper.EmpExprMapper;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpExpr;
import com.tlias.pojo.EmpGenderStatistic;
import com.tlias.req.NewEmpReq;
import com.tlias.req.QueryEmpPagedReq;
import com.tlias.req.UpdateEmpReq;
import com.tlias.resp.QueryEmpResp;
import com.tlias.resp.UpdateEmpResp;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public QueryEmpResp queryEmp(QueryEmpPagedReq req) {
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
    public void saveEmp(NewEmpReq req) {
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Integer> ids) {
        if(!CollectionUtils.isEmpty(ids)){
            empExprMapper.deleteByEmpIds(ids);
            empMapper.deleteByIds(ids);
        }
    }

    @Override
    public UpdateEmpResp queryEmpById(Integer id) {
        return empMapper.queryEmpById(id);
    }

    @Override
    public void updateEmp(UpdateEmpReq req) {
        Emp emp = req.getEmp();
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);

        List<EmpExpr> empExprs = req.getEmpExprList();
        empExprs.forEach(empExpr -> {
            empExpr.setEmpId(emp.getId());
        });
        if(!CollectionUtils.isEmpty(empExprs)){
            List<Integer> ids = new ArrayList<>();
            ids.add(emp.getId());
            empExprMapper.deleteByEmpIds(ids);
            empExprMapper.batchInsertEmpExpr(empExprs);
        }
    }

    @Override
    public List<EmpGenderStatistic> empGenderStatistic() {
        return empMapper.empGenderStatistic();
    }
}
