package com.tlias.mapper;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpExpr;
import com.tlias.pojo.EmpGenderStatistic;
import com.tlias.resp.UpdateEmpResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 修改员工查询回显
     * @param id
     * @return
     */
    UpdateEmpResp queryEmpById(Integer id);

    /**
     * 分页查询员工信息
     * @param offset
     * @param pageSize
     * @return 当前页的员工信息
     */
    List<Emp> queryEmp(String name, Integer gender, LocalDate begin, LocalDate end,
                       Integer offset, Integer pageSize);

    /**
     * 获取员工数量
     * @return 员工数量
     */
    Integer getCount(String name, Integer gender, LocalDate begin, LocalDate end);

    
    void insertEmp(Emp emp);


    void deleteByIds(List<Integer> ids);

    void updateEmp(Emp emp);

    Integer selectCountByDeptId(Integer deptId);

    List<EmpGenderStatistic> empGenderStatistic();

    Emp selectEmpByUsernameAndPassword(String username, String password);
}
