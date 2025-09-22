package com.tlias.mapper;

import com.tlias.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void batchInsertEmpExpr(List<EmpExpr> empExprs);

    void deleteByEmpIds(List<Integer> empIds);
}
