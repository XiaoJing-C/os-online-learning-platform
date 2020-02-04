package com.jxnu.os.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author xiao
 * 成绩实体类
 */
public class Grade {

    //成绩主键ID
    private Integer id;
    //试卷ID号
    private Integer p_id;
    //学生学号
    private String s_id;
    //分数
    private Integer totalScores;
    //单选分
    private Integer singleScores;
    //多选分
    private Integer multipleScores;
    //填空分
    private Integer exerciseScores;
    //时间
    private Timestamp create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public Integer getTotalScores() {
        return totalScores;
    }

    public void setTotalScores(Integer totalScores) {
        this.totalScores = totalScores;
    }

    public Integer getSingleScores() {
        return singleScores;
    }

    public void setSingleScores(Integer singleScores) {
        this.singleScores = singleScores;
    }

    public Integer getMultipleScores() {
        return multipleScores;
    }

    public void setMultipleScores(Integer multipleScores) {
        this.multipleScores = multipleScores;
    }

    public Integer getExerciseScores(Integer exerciseScores) {
        return this.exerciseScores;
    }

    public void setExerciseScores(Integer exerciseScores) {
        this.exerciseScores = exerciseScores;
    }


    public Integer getExerciseScores() {
        return exerciseScores;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", p_id=" + p_id +
                ", s_id=" + s_id +
                ", totalScores=" + totalScores +
                ", singleScores=" + singleScores +
                ", multipleScores=" + multipleScores +
                ", exerciseScores=" + exerciseScores +
                ", create_time=" + create_time +
                '}';
    }
}
