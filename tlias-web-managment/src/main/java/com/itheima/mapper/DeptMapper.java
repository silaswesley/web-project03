package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 部门查询
     */
    @Select("select id, name, create_time , update_time  from dept order by update_time; ")
    public List<Dept> findAll();

    /**
     * 删除部门
     */
    @Delete("delete from dept where id= #{id}")
    public void deleteByid(Integer id);

    /**
     * 新增部门
     */
    @Insert("insert into dept (name,create_time,update_time) value (#{name},#{createTime},#{updateTime}) ")
    void add(Dept dept);

    /**
     * 修改部门
     * 1.根据部门id查询回显部门名称
     * 2.修改部门
     */
    @Select("select * from dept where id = #{id}")
    Dept selectByid(Integer id);
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void updateDept(Dept dept);
}
