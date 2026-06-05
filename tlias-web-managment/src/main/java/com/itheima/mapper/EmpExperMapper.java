package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExperMapper {
    /**
     * 批量保存员工的工作经历信息
     */

    void insertBatch(List<EmpExpr> exprList);

    /**
     * 删除员工
     */
    void deleteByEmpIds(List<Integer> ids);
}
