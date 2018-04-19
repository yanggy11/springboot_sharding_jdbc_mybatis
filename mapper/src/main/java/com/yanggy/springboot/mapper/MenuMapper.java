package com.yanggy.springboot.mapper;

import com.yanggy.springboot.dto.in.MenuParam;
import com.yanggy.springboot.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by yangguiyun on 2018/4/18.
 */

@Mapper
public interface MenuMapper {
    List<Menu> getMenusByPage(MenuParam menuParam);

    int countMenus(MenuParam menuParam);

    List<Menu> getMenus(MenuParam menuParam);

    int addMenu(Menu menu);

    int editMenu(Menu menu);
}
