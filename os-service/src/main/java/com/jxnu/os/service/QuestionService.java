package com.jxnu.os.service;

import com.jxnu.os.mapper.QuestionMapper;
import com.jxnu.os.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xiao
 */
@Service
public class QuestionService {
    @Autowired
    QuestionMapper questionMapper;

    public List<Map<String,Object>> findSingleQuestions(Integer p_id){
        return questionMapper.findSingleQuestions(p_id);
    }

    public List<Map<String,Object>> findMultipleQuestions(Integer p_id){
        return questionMapper.findMultipleQuestions(p_id);
    }
    public List<Map<String,Object>> findExerciseQuestions(Integer p_id){
        return questionMapper.findExerciseQuestions(p_id);
    }
    public Question findAnswerById(String id) {
        return questionMapper.findAnswerById(id);
    }
}
