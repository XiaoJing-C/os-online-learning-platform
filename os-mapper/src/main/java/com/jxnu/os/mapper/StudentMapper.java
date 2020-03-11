package com.jxnu.os.mapper;

import com.jxnu.os.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiao
 */
public interface StudentMapper {

    Student loadUserBySno(String sno);

    List<Student> getAll(@Param("id") Integer id, @Param("keywords") String keywords);

    List<Student> getAllStu(@Param("keywords") String keywords);

    Student selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Student student);

    int updateByPrimaryKey(Student student);

    int modifyPass(@Param("sno") String sno,@Param("rePassword") String rePassword);

    int base64Upload(@Param("imgFilePath") String imgFilePath,@Param("id") Integer id);

//    Student selectUrl(Integer id);

}
