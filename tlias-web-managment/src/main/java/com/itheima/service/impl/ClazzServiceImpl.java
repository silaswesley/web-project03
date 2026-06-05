package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService{
    @Autowired
    ClazzMapper clazzMapper;
//    @Override
//    public PageResult<Clazz> page(Integer page, Integer pagesize) {
//       1.调用mapper接口，查询总记录数
//       Long total = clazzMapper.count();
//       2.调用mapper接口，查询结果列表
//       Integer start = (page - 1) * pagesize;
//       List<Clazz> rows = clazzMapper.list(start, pagesize);
//       3.封装结果PageResult
//       return new PageResult<Clazz>(total,rows);
//    }

    /**
     * 分页查询
     */
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam){
        //1.设置分页参数（PageHelper）
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        //2.执行查询
         List<Clazz> clazzlist = clazzMapper.list(clazzQueryParam);
        //3.解析查询结果，并封装
        Page<Clazz> c = (Page<Clazz>) clazzlist;
        return new PageResult<>(c.getTotal(),c.getResult());
    }

    /**
     * 删除班级
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleById(Integer id) {
        // 1. 检查是否有学生
        int studentCount = clazzMapper.countStudentsByClazzId(id);
        if (studentCount > 0) {
            throw new RuntimeException("对不起, 该班级下有学生, 不能直接删除");
        }
        // 3. 执行删除
        clazzMapper.deleteById(id);
    }

    /**
     * 新增班级
     */
    @Override
    public Result addClazz(Clazz clazz) {
        try {
            // 1. 校验班级名称字符合法性（业务规则）
            if (clazz.getName() != null) {
                String name = clazz.getName().trim();
                if (!name.matches("[\\u4e00-\\u9fa5a-zA-Z0-9]+")) {
                    return Result.error("班级名称只能包含汉字、数字、字母");
                }
            }

            // 2. 校验时间顺序（业务规则）
            if (clazz.getBeginDate() != null && clazz.getEndDate() != null &&
                    clazz.getBeginDate().isAfter(clazz.getEndDate())) {
                return Result.error("开课时间不能晚于结课时间");
            }

            // 3. 校验学科范围（业务规则）
            Integer subject = clazz.getSubject();
            if (subject != null && (subject < 1 || subject > 6)) {
                return Result.error("学科必须为1-6之间的有效值");
            }

            // 4. 直接插入，依赖数据库约束
            clazzMapper.insert(clazz);
            return Result.success();

        } catch (DuplicateKeyException e) {
            return Result.error("班级名称已存在，请更换");
        } catch (DataIntegrityViolationException e) {
            return Result.error("输入数据不符合要求，请检查后重试");
        } catch (Exception e) {
            return Result.error("新增失败");
        }
    }

    /**
     * 修改部门
     * 1.根据部门id查询回显部门名称
     * 2.修改部门
     */
    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }
}
