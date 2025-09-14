package com.tlias.resp;

import com.tlias.pojo.Emp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryEmpPagedResp {

    private List<Emp> rows;

    private Integer total;
}
