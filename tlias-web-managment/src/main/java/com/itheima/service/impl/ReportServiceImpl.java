package com.itheima.service.impl;

import com.itheima.mapper.ClazzMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.StudentDegreeData;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ReportServiceImpl implements ReportService {
    /**
     * 统计员工职位人数
     */
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public JobOption getEmpJobData() {
        // 1. 调用 mapper 接口，获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpJobData(); // map: pos=教研主管, num=1

        // 2. 组装结果，并返回
       List<Object> jobList = list.stream().map(dataMap ->dataMap.get("pos")).toList();
       List<Object> dataList = list.stream().map(dataMap ->dataMap.get("num")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
    /**
     * 统计员工学历信息
     */
    @Override
    public List<Map<String,Object>> getStudentDegreeData() {
        List<Map<String, Object>> list = studentMapper.countStudentData();
        List<Object> nameList = list.stream().map(dataMap ->dataMap.get("name")).toList();
        List<Object> valueList = list.stream().map(dataMap ->dataMap.get("value")).toList();

        return studentMapper.countStudentData();
    }

    /**
     * 统计班级人数信息
     */
    @Override
    public ClazzOption getClazzData() {
        List<Map<String,Object>> list = clazzMapper.countClazzData();

        List<Object> clazzList = list.stream().map(dataMap ->dataMap.get("pos")).toList();
         List<Object> valueList = list.stream().map(dataMap ->dataMap.get("num")).toList();
        return new ClazzOption(clazzList, valueList);
    }

}
