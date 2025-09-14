package com.tlias.mapper;

import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 分页查询员工信息
     * @param offset
     * @param pageSize
     * @return 当前页的员工信息
     */
    @Select("select e.*, d.name deptName from emp e left join dept d " +
            "on e.dept_id = d.id order by e.update_time desc limit #{offset}, #{pageSize}")
    List<Emp> queryEmpPaged(Integer offset, Integer pageSize);

    /**
     * 获取员工数量
     * @return 员工数量
     */
    @Select("select count(*) from emp")
    Integer getCount();
}
