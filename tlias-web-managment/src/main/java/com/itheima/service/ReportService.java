package com.itheima.service;

import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.StudentDegreeData;

import java.util.List;
import java.util.Map;

public interface ReportService {

    /**
     * 统计员工职位人数
     */
    JobOption getEmpJobData();


    List<Map<String, Object>> getEmpGenderData();

    /**
     * 统计员工学历信息
     */
    List<Map<String,Object>> getStudentDegreeData();

    /**
     * 统计班级人数信息
     */
    ClazzOption getClazzData();
}
