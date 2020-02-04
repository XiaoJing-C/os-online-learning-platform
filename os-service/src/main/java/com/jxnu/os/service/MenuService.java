package com.jxnu.os.service;

import com.jxnu.os.mapper.MenuMapper;
import com.jxnu.os.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiao
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenuByParentId(-1);
    }

    public void addMenu(Menu menu) {
        menuMapper.addMenu(menu);
    }

    public void deleteMenuById(Menu menu) {
        menuMapper.deleteMenuById(menu);
    }

    public List<Menu> getAllMenuWithOutChildren() {
        return menuMapper.getAllMenuWithOutChildren();
    }
}
