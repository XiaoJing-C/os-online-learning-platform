package com.jxnu.os.controller;

import com.jxnu.os.model.Grade;
import com.jxnu.os.model.Question;
import com.jxnu.os.model.RespBean;
import com.jxnu.os.service.GradeService;
import com.jxnu.os.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author xiao
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @Autowired
    QuestionService questionService;

    @RequestMapping("/postExam")
    public RespBean postExam(@RequestParam Map<String,String> map, String sno) {
        Integer p_id = null;
        Question questions;
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        int singleScores = 0;     //单选分
        int multipleScores = 0;    //多选分
        int exerciseScores = 0;    //填空分
        int total = 0;         //总得分
        while (it.hasNext()) {
            String key = it.next();
            String value = map.get(key);
            questions = questionService.findAnswerById(key);
            p_id = questions.getP_id();
            if (questions.getType().equals("单选")) {

                if (questions.getAnswer().equals(value)) {
                    singleScores += 2;
                }
            }
            if (questions.getType().equals("多选")) {

                if (questions.getAnswer().equals(value)) {
                    multipleScores += 3;
                }
            }
            if (questions.getType().equals("填空")) {

                if (questions.getAnswer().equals(value)) {
                    exerciseScores += 1;
                }
            }
        }

        total = singleScores + multipleScores + exerciseScores;
        Grade grade = new Grade();
        grade.setCreate_time(new Timestamp(new Date().getTime()));
        grade.setSingleScores(singleScores);
        grade.setMultipleScores(multipleScores);
        grade.setExerciseScores(exerciseScores);
        grade.setTotalScores(total);
        grade.setCreate_time(new Timestamp(new Date().getTime()));
        grade.setP_id(p_id);
        grade.setS_id(sno);
        gradeService.addStuExamResult(grade);
        return RespBean.ok("");
    }
    @GetMapping("/queryResult")
    public Grade findExamBySno(String sno) {
        return gradeService.findExamBySno(sno);
    }



}
