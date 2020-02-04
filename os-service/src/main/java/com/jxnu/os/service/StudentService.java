package com.jxnu.os.service;

import com.jxnu.os.mapper.StudentMapper;
import com.jxnu.os.model.Student;
import com.jxnu.os.utils.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiao
 */
@Service
public class StudentService implements UserDetailsService {

    @Autowired
    StudentMapper studentMapper;

    /**
     * 登录
     * @param sno
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String sno) throws UsernameNotFoundException {

        Student student = studentMapper.loadUserBySno(sno);
        if (student == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return student;
    }

    /**
     * 注册
     * @param student
     * @return
     */
    public boolean register(Student student) {
        Student existUser = studentMapper.loadUserBySno(student.getUsername());
        if (existUser != null) {
            //如果用户名已存在
            return false;

        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encode = encoder.encode(student.getPassword());
            student.setPassword(encode);
            studentMapper.insert(student);
            return true;
        }
    }

    /**
     * 修改密码
     * @param sno
     * @param password
     * @param rePassword
     * @return
     */
    public boolean modifyPass(String sno,String password,String rePassword) {
        Student student = studentMapper.loadUserBySno(sno);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password,student.getPassword())) {
            String encode = encoder.encode(rePassword);
            rePassword = encode;
            studentMapper.modifyPass(sno,rePassword);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 查询多条学生记录
     * @param keywords
     * @return
     */
    public List<Student> getAllStu(String keywords) {
        return studentMapper.getAllStu(StudentUtils.getCurrentStu().getId(),keywords);
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    public Integer updateStu(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    /**
     * 根据主键ID删除学生记录
     * @param id
     * @return
     */
    public Integer deleteStuById(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }
}
