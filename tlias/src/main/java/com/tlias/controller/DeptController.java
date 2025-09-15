package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/depts")
@RestController
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping //限制请求方式为GET
    public Result list(){
        log.info("获取全部部门");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping
    public Result delete(Integer id){//前端请求参数名称和后端方法参数名称一致时，可省略@RequestParam注解
        log.info("删除指定部门, id:{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){//@RequestBody注解用于将请求体中的JSON数据绑定到Java对象上
        log.info("新增部门, dept:{}", dept);
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable("id") Integer id){//这叫路径参数，跟请求参数不一样，请求参数是?name=xxx
        log.info("根据id查询部门, id:{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新部门, dept:{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
