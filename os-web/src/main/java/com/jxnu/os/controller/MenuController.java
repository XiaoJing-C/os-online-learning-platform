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
@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;
    @GetMapping("/by/{parent_id}")
    public List<Menu> getAllMenu(@PathVariable Integer parent_id) {
        return menuService.getAllMenu(parent_id);
    }

    @GetMapping("/all")
    public  List<Menu> getAllMenuWithOutChildren() {
        return menuService.getAllMenuWithOutChildren();
    }

    @PostMapping("/add")
    public RespBean addMenu(Menu menu) {
        menuService.addMenu(menu);
        if (menu.getResult() == 1) {
            return RespBean.ok("添加成功", menu);
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/del/{id}")
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
