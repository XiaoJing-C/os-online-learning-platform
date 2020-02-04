package com.jxnu.os.mapper;

import com.jxnu.os.model.Question;

import java.util.List;
import java.util.Map;

/**
 * @author xiao
 */
public interface QuestionMapper {
    //返回单选题目
    List<Map<String,Object>> findSingleQuestions(Integer p_id);
    //返回多选题目
    List<Map<String,Object>> findMultipleQuestions(Integer p_id);
    //返回填空题
    List<Map<String,Object>> findExerciseQuestions(Integer p_id);

    Question findAnswerById(String id);
}
