package com.tlias.req;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpExpr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewEmpReq {

     private Emp emp;

     private List<EmpExpr> empExprs;
}
