package com.tlias.resp;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpExpr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
修改员工查询回显类
 */
public class UpdateEmpResp {

    private Emp emp;

    private List<EmpExpr> empExprList;
}
