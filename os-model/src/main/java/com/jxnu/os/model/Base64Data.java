package com.jxnu.os.model;

import java.util.Arrays;

/**
 * @author xiao
 */
public class Base64Data {
    private String[] base64Data;

    private Integer id;

    public String[] getBase64Data() {
        return base64Data;
    }

    public void setBase64Data(String[] base64Data) {
        this.base64Data = base64Data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Base64Data{" +
                "base64Data=" + Arrays.toString(base64Data) +
                ", id=" + id +
                '}';
    }
}
