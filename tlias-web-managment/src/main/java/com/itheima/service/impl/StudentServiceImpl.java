package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudnetQueryParam;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    /**
     * 分页查询
     */
    @Override
    public PageResult<Student> page(StudnetQueryParam studnetQueryParam) {
        //1.设置分页参数（PageHelper）
       PageHelper.startPage(studnetQueryParam.getPage(),studnetQueryParam.getPageSize());
        //2.执行查询
        List<Student> studentList = studentMapper.list(studnetQueryParam);
        //3.解析查询结果，并封装
        Page<Student> s = (Page<Student>) studentList;
        return  new PageResult<>(s.getTotal(),s.getResult());
    }
    /**
     * 删除学员
     */
    @Override
    public void delete(List<Integer> ids) {
        //1.批量删除员工基本信息
        studentMapper.deltByIds(ids);

    }
    /**
     * 新增学员
     */
    @Override
    public void save(Student student) {
        //1.保存员工基本信息
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);

    }

    /**
     * 根据Id查询学生信息
     */
    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    /**
     * 修改员工信息
     */
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }
}
