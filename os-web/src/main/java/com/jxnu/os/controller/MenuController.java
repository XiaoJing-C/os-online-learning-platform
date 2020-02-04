package com.jxnu.os.controller;

import com.jxnu.os.model.Menu;
import com.jxnu.os.model.RespBean;
import com.jxnu.os.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiao
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;
    @GetMapping("/")
    public List<Menu> getAllMenu() {
        return menuService.getAllMenu();
    }
    
    @PostMapping("/")
    public RespBean addMenu(Menu menu) {
        menuService.addMenu(menu);
        if (menu.getResult() == 1) {
            return RespBean.ok("添加成功", menu);
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteMenuById(@PathVariable Integer id) {
        Menu menu = new Menu();
        menu.setId(id);
        menuService.deleteMenuById(menu);
        if (menu.getResult() == -2) {
            return RespBean.error("该目录下有子目录，删除失败");
        } else if (menu.getResult() == -1) {
            return RespBean.error("该目录下有内容，删除失败");
        } else if (menu.getResult() == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
