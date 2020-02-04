package com.jxnu.os.mapper;

import com.jxnu.os.model.Grade;
import com.jxnu.os.model.Question;
import com.jxnu.os.model.Student;

import java.util.List;
import java.util.Map;

/**
 * @author xiao
 */

public interface GradeMapper {

    int addStuExamResult(Grade grade);
    Student findExamStuBySno(String sno);
    Grade findExamBySno(String sno);

}
