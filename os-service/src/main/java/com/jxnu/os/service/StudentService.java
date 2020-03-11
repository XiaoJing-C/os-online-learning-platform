package com.jxnu.os.service;

import com.jxnu.os.mapper.StudentMapper;
import com.jxnu.os.model.Base64Data;
import com.jxnu.os.model.RespBean;
import com.jxnu.os.model.Student;
import com.jxnu.os.utils.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author xiao
 */
@Service
@CacheConfig(cacheNames = "student")
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
//    @Caching(
//            cacheable = {@Cacheable(key="#keywords")},
//            put={ @CachePut(key = "#result.username"),
//                    @CachePut(key = "#result.sno")
//            }
//    )
    @Cacheable(key = "#targetClass + methodName +#p0")
    public List<Student> getAllStu(String keywords) {
        return studentMapper.getAllStu(keywords);
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @CachePut(key = "#targetClass + methodName +#p0")
    public Integer updateStu(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    /**
     * 根据ID查询学生信息
     * @param id
     * @return
     */
    @Cacheable(key = "#targetClass + methodName +#p0")
    public Student getStuById(Integer id){
        return studentMapper.selectByPrimaryKey(id);
    }
    /**
     * 根据主键ID删除学生记录
     * @param id
     * @return
     */
    @CacheEvict
    public Integer deleteStuById(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 上传头像
     * @param base64Data
     * @return
     * @throws FileNotFoundException
     */
    public RespBean base64Upload(Base64Data base64Data) throws FileNotFoundException {
        Integer id = base64Data.getId();
        List<String> List = Arrays.asList(base64Data.getBase64Data());

//        for (String x : List) {
//            System.out.println(x);
            String dataP = ""; //base64格式前头
            String data = "";//实体部分数据
            if (List.get(0) == null || "".equals(List.get(0)) || List.get(1) == null || "".equals(List.get(1)) ) {
               return RespBean.error("上传失败，上传图片数据为空");
            } else {
                dataP = List.get(0); //base64格式前头
                data = List.get(1);//实体部分数据
//                System.out.println(data);
            }
                String suffix = "";
                //图片后缀，用以识别哪种格式数据
                //data:image/jpeg;base64,base64编码的jpeg图片数据
                if ("data:image/jpeg;base64".equalsIgnoreCase(dataP)) {
                    suffix = ".jpg";
                } else if ("data:image/x-icon;base64".equalsIgnoreCase(dataP)) {
                    //data:image/x-icon;base64,base64编码的icon图片数据
                    suffix = ".ico";
                } else if ("data:image/gif;base64".equalsIgnoreCase(dataP)) {
                    //data:image/gif;base64,base64编码的gif图片数据
                    suffix = ".gif";
                } else if ("data:image/png;base64".equalsIgnoreCase(dataP)) {
                    //data:image/png;base64,base64编码的png图片数据
                    suffix = ".png";
                } else {
                   return RespBean.error("上传图片格式不合法");
                }
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                String tempFileName = uuid + suffix;
                String imgFilePath = "/usr/java/image/os/" + tempFileName;//新生成的图片
                BASE64Decoder decoder = new BASE64Decoder();
                OutputStream out = new FileOutputStream(imgFilePath);
                try {
                    //Base64解码
                    byte[] b = decoder.decodeBuffer(data);
                    for (int i = 0; i < b.length; ++i) {
                        if (b[i] < 0) {
                            //调整异常数据
                            b[i] += 256;
                        }
                    }
                    out.write(b);
                    out.flush();
                    out.close();
                    String avatarUrl = "http://120.76.40.183:8082/images/" + tempFileName;
                    studentMapper.base64Upload(avatarUrl,id);
                } catch (IOException e) {
                    e.printStackTrace();
                    return RespBean.error("上传图片失败");
                }

        String url = "http://120.76.40.183:8082/images/" + tempFileName;
        return  RespBean.ok("上传成功",url);

    }
}
