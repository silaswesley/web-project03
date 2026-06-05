package com.itheima.controller;

import com.itheima.pojo.*;
import com.itheima.service.ClazzService;
import com.itheima.service.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clazzs")
@RestController
public class ClazzController {

   @Autowired
   private ClazzService clazzService;

    /**
     * 分页查询
     */
    @GetMapping()
    public Result page(ClazzQueryParam clazzQueryParam){
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 删除班级
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        try {
            clazzService.deleById(id);
            return Result.success(); // 删除成功
        } catch (RuntimeException e) {
            return Result.error(e.getMessage()); // 返回错误提示
        }
    }

    /**
     * 新增班级
     */
    @PostMapping("")
    public Result addClazz(@RequestBody Clazz clazz) {
        return clazzService.addClazz(clazz);
    }

    /**
     * 修改班级
     * 1.根据班级id查询回显部门名称
     * 2.修改部门
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        clazzService.update(clazz);
        return Result.success();
    }
}
