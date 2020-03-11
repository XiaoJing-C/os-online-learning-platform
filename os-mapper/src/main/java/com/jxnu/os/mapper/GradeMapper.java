package com.jxnu.os.mapper;

import com.jxnu.os.model.Grade;
import com.jxnu.os.model.Student;


/**
 * @author xiao
 */

public interface GradeMapper {

    int addStuExamResult(Grade grade);
    Student findExamStuBySno(String sno);
    Grade findExamBySno(String sno);

}
