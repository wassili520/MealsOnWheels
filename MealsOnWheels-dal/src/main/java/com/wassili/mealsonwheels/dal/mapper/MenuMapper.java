package com.wassili.mealsonwheels.dal.mapper;

import com.wassili.mealsonwheels.dal.model.Menu;

public interface MenuMapper {

    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}