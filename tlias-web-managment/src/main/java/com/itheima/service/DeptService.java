package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 部门查询
     */
    List<Dept> findAll();

    /**
     * 删除部门
     */
    void deleteByid(Integer id);

    /**
     * 新增部门
     */
    void add(Dept dept);

    /**
     * 修改部门
     * 1.根据部门id查询回显部门名称
     * 2.修改部门
     */
    Dept selectByid(Integer id);

    void updateDept(Dept dept);
}
