package com.tlias.service;


import com.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void insert(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
