package com.itheima.controller;

import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.pojo.StudentDegreeData;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
       JobOption jobOption= reportService.getEmpJobData();
       return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        List<Map<String,Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 统计员工学历信息
     *
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
     List<Map<String,Object>> studentDegreeDataList = reportService.getStudentDegreeData();
     return Result.success(studentDegreeDataList);
    }

    /**
     * 统计班级人数
     */
    @GetMapping("/studentCountData")
    public Result getClazzData(){
            ClazzOption clazzOption = reportService.getClazzData();
            return Result.success(clazzOption);
    }
}
