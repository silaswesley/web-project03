package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    /**
     * 部门查询
     */
    @GetMapping
    public Result list(){
      List<Dept> deptList = deptService.findAll();
      return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @DeleteMapping
    public Result deleteById(Integer id){
        deptService.deleteByid(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping
    public Result AddDept(@RequestBody Dept dept){
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 修改部门
     * 1.根据部门id查询回显部门名称
     * 2.修改部门
     */
    @GetMapping("/{id}")
    public Result  SelectById(@PathVariable Integer id){
        Dept dept = deptService.selectByid(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateDept(dept);
        return Result.success();
    }
}
