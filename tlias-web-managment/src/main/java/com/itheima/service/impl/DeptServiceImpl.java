package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 部门查询
     */
    @Override
    public List<Dept> findAll(){
         return deptMapper.findAll();
    }

    /**
     * 删除部门
     */
    @Override
    public void deleteByid(Integer id) {
        deptMapper.deleteByid(id);
    }

    /**
     * 新增部门
     */
    @Override
    public void add(Dept dept) {
        //1.补全基础信息
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //2.调用Mapping
        deptMapper.add(dept);
    }

    /**
     * 修改部门
     * 1.根据部门id查询回显部门名称
     * 2.修改部门
     */
    @Override
    public Dept selectByid(Integer id) {

        return deptMapper.selectByid(id);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }


}
