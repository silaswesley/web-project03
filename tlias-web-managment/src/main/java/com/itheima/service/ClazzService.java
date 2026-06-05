package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import jakarta.validation.Valid;

public interface ClazzService {
//    PageResult<Clazz> page (Integer page,Integer pagesize);
    /**
     * 分页查询
     */
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    /**
     * 删除班级
     */
    void deleById(Integer id);

    /**
     * 新增班级
     */
    Result addClazz(Clazz clazz);
    
    /**
     * 修改部门
     * 1.根据部门id查询回显部门名称
     * 2.修改部门
     */
    Clazz getInfo(Integer id);

    void update(Clazz clazz);
}
