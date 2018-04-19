package com.yanggy.springboot.service;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.MenuParam;
import com.yanggy.springboot.entity.Menu;

/**
 * Created by yangguiyun on 2018/4/18.
 */
public interface MenuService {

    ResponseEntityDto<?> getMenusByPage(MenuParam menuParam);

    ResponseEntityDto<?> getMenus(MenuParam menuParam);

    ResponseEntityDto<?> addMenu(Menu menu);

    ResponseEntityDto<?> editMenu(Menu menu);
}
