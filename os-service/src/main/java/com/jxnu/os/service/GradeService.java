package com.jxnu.os.service;

import com.jxnu.os.mapper.GradeMapper;
import com.jxnu.os.model.Grade;
import com.jxnu.os.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xiao
 */
@Service
public class GradeService {
    @Autowired
    GradeMapper gradeMapper;

    public Grade findExamBySno(String sno) {
        return gradeMapper.findExamBySno(sno);
    }
    public Student findExamStuBySno(String sno) {
        return gradeMapper.findExamStuBySno(sno);
    }
    public void addStuExamResult(Grade grade) {
        gradeMapper.addStuExamResult(grade);
    }
}
