package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudnetQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    /**
     *条件查询学员信息
     */
    List<Student> list(StudnetQueryParam studnetQueryParam);

    /**
     * 删除学员
     */
    void deltByIds(List<Integer> ids);

    /**
     * 新增学员
     */
    @Insert("INSERT INTO student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) " +
            "VALUES (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{violationCount}, #{violationScore}, #{createTime}, #{updateTime})")
    void insert(Student student);

    /**
     * 根据Id查询学生信息
     */
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getById(Integer id);

    /**
     * 修改员工信息
     */
    @Update({
            "<script>",
            "UPDATE student",
            "SET name = #{name},",
            "    no = #{no},",
            "    gender = #{gender},",
            "    phone = #{phone},",
            "    id_card = #{idCard},",
            "    is_college = #{isCollege},",
            "    address = #{address},",
            "    degree = #{degree},",
            "    graduation_date = #{graduationDate},",
            "    clazz_id = #{clazzId},", // 必须提供，非空
            "    violation_count = #{violationCount},",
            "    violation_score = #{violationScore},",
            "    update_time = NOW()",
            "WHERE id = #{id}",
            "</script>"
    })
    void updateById(Student student);

    /**
     * 统计员工学历信息
     */
    List<Map<String,Object>> countStudentData();
}
