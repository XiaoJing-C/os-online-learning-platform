package com.jxnu.os.utils;

import com.jxnu.os.model.Student;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author xiao
 */
public class StudentUtils {
    public static Student getCurrentStu() {
        return ((Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
