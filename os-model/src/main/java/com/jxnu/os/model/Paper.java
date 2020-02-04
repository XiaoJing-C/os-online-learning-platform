package com.jxnu.os.model;

import java.util.Date;

/**
 * @author xiao
 * 试卷实体类
 */
public class Paper {

    //试卷主键ID
    private Integer id;
    //教师ID号
    private Integer tid;
    //试卷名称
    private String p_name;
    //试卷添加时间
    private Date join_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Date getJoin_time() {
        return join_time;
    }

    public void setJoin_time(Date join_time) {
        this.join_time = join_time;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", tid=" + tid +
                ", p_name='" + p_name + '\'' +
                ", join_time=" + join_time +
                '}';
    }
}
