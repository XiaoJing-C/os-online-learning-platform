package com.jxnu.os.mapper;

import com.jxnu.os.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiao
 */
public interface StudentMapper {

    Student loadUserBySno(String sno);

    List<Student> getAllStu(@Param("sno") Integer sno, @Param("keywords") String keywords);

    Student selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Student student);

    int updateByPrimaryKey(Student student);

    int modifyPass(String sno,String rePassword);
}
