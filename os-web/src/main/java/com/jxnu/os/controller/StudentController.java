package com.jxnu.os.controller;

import com.jxnu.os.model.Base64Data;
import com.jxnu.os.model.RespBean;
import com.jxnu.os.model.Student;
import com.jxnu.os.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;


/**
 * @author xiao
 */
@CrossOrigin
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

    /**
     * 修改密码
     * @param sno
     * @param password
     * @param rePassword
     * @return
     */
    @PutMapping("/modifyPass")
    public RespBean modifyPass(String sno,String password,String rePassword) {
        if(studentService.modifyPass(sno,password,rePassword)){
            return RespBean.ok("修改成功");
        }else{
            return RespBean.error("修改失败,原密码错误");
        }
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @PutMapping("/updateStu")
    public RespBean updateStu(Student student) {
        if (studentService.updateStu(student) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    /**
     * 根据ID删除学生记录
     * @param id
     * @return
     */
    @DeleteMapping("/deleteStuById/{id}")
    public RespBean deleteStuById(@PathVariable Integer id) {
        if (studentService.deleteStuById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    /**
     * 根据ID查询学生记录
     * @param id
     * @return
     */
    @GetMapping("/getStuById/{id}")
    public RespBean getStuById(@PathVariable Integer id) {
        if(studentService.getStuById(id).getId() != null) {
            return RespBean.ok("查询成功",studentService.getStuById(id));
        }else {
            return RespBean.error("查询失败");
        }
    }

    /**
     * 上传头像
     * @param base64Data
     * @return
     * @throws FileNotFoundException
     */
    @PostMapping("/base64Upload")
    public RespBean base64Upload(Base64Data base64Data) throws FileNotFoundException {
        return studentService.base64Upload(base64Data);
    }
}
