package com.tlias.service.impl;

import com.tlias.mapper.DeptMapper;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Dept;
import com.tlias.resp.JobCountStatisticResp;
import com.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void insert(Dept dept) {
        LocalDateTime now = LocalDateTime.now();
        dept.setCreateTime(now);
        dept.setUpdateTime(now);
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getById(id);
        return dept;
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    public JobCountStatisticResp jobCountStatic() {
        Map<String, Integer> deptName2Count = new HashMap<>();
        List<Dept> deptNameList = deptMapper.getAllDeptName();
        JobCountStatisticResp jobCountStatisticResp = new JobCountStatisticResp();
        deptNameList.forEach(dept -> {
            Integer count = empMapper.selectCountByDeptId(dept.getId());
            deptName2Count.put(dept.getName(), count == null ? 0 : count);
        });
        List<String> jobList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        deptName2Count.forEach((name, count) -> {
            jobList.add(name);
            countList.add(count);
        });
        jobCountStatisticResp.setJobList(jobList);
        jobCountStatisticResp.setCountList(countList);
        return jobCountStatisticResp;
    }
}
