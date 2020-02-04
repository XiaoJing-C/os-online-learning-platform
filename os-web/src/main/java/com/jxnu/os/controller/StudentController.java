package com.jxnu.os.controller;

import com.jxnu.os.model.RespBean;
import com.jxnu.os.model.Student;
import com.jxnu.os.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author xiao
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * 注册
     * @param student
     * @return
     */
    @PostMapping("/register")
    public RespBean register(Student student) {
        if(studentService.register(student)){
            return RespBean.ok("注册成功",student);
        }else{
            return RespBean.error("注册失败，用户名已存在");
        }
    }
    @GetMapping("/getAllStu")
    public List<Student> getAllStu(String keywords) {
        return studentService.getAllStu(keywords);
    }

    @PutMapping("/modifyPass")
    public RespBean modifyPass(String sno,String password,String rePassword) {
        if(studentService.modifyPass(sno,password,rePassword)){
            return RespBean.ok("修改成功");
        }else{
            return RespBean.error("修改失败,原密码错误");
        }
    }

    @PutMapping("/updateStu")
    public RespBean updateStu(Student student) {
        if (studentService.updateStu(student) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/deleteStuById/{id}")
    public RespBean deleteStuById(@PathVariable Integer id) {
        if (studentService.deleteStuById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
