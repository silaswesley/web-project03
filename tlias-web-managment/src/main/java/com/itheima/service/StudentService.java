package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudnetQueryParam;

import java.util.List;

public interface StudentService {
    /**
     * 分页查询
     */
    PageResult<Student> page(StudnetQueryParam studnetQueryParam);

    /**
     * 删除员工
     */
    void delete(List<Integer> ids);

    /**
     * 新增学员
     */
    void save(Student student);
    /**
     * 根据Id查询学生信息
     */
    Student getInfo(Integer id);
    /**
     * 修改员工信息
     */
    void update(Student student);
}
