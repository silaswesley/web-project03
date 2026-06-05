package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {
    /**
     *条件查询班级信息
     */
    public List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     *删除班级信息
     */
    // 检查班级下是否有学生
    @Select("SELECT COUNT(*) FROM student WHERE clazz_id = #{id}")
    int countStudentsByClazzId(Integer id);
    // 删除班级（仅当无学生时才调用）
    @Delete("DELETE FROM clazz WHERE id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增班级
     */
    @Insert("INSERT INTO clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "VALUES (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, NOW(), NOW())")
    void insert(Clazz clazz);
    
    /**
     * 修改部门
     * 1.根据部门id查询回显部门名称
     * 2.修改部门
     */

    Clazz getById(Integer id);

    void updateById(Clazz clazz);


    /**
     * 统计班级人数
     * countEmpJobData
     */
    List<Map<String, Object>> countClazzData();
}
