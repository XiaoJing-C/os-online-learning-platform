package com.jxnu.os.model;

/**
 * @author xiao
 * 管理员实体类
 */
public class Admin {

    //管理员主键ID
    private Integer id;
    //状态  默认值为0--》老师  1--》管理员
    private Integer access;
    //姓名
    private String a_name;
    //密码
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", access=" + access +
                ", a_name='" + a_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
