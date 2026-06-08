package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.LogInfo;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")

@RestController
public class LogInfoController {
    @Autowired
    EmpService empService;
    @PostMapping()
    public Result login(@RequestBody Emp emp) {
         LogInfo login= empService.login(emp);
         if(login!=null){
             return Result.success(login);
         }
         return  Result.error("用户名或密码错误");
    }
}
