package com.jxnu.os.mapper;

import com.jxnu.os.model.Menu;

import java.util.List;

/**
 * @author xiao
 */
public interface MenuMapper {
    List<Menu> getAllMenuByParentId(Integer parent_id);
    int deleteByPrimaryKey(Integer id);

    int insert(Menu menu);

    int insertSelective(Menu menu);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu menu);

    int updateByPrimaryKey(Menu menu);


    void addMenu(Menu menu);

    void deleteMenuById(Menu menu);

    List<Menu> getAllMenuWithOutChildren();
}
