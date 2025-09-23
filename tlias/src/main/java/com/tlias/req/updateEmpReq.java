package com.tlias.req;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpExpr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class updateEmpReq {

    private Emp emp;

    private List<EmpExpr> empExprList;
}
