package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.common.ResponseEntityBuilder;
import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.MenuParam;
import com.yanggy.springboot.entity.Menu;
import com.yanggy.springboot.mapper.MenuMapper;
import com.yanggy.springboot.service.MenuService;
import com.yanggy.springboot.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/18 15:53
 * @Description:
 */

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public ResponseEntityDto<?> getMenusByPage(MenuParam menuParam) {
        List<Menu> menus = menuMapper.getMenusByPage(menuParam);
        int menusCount = menuMapper.countMenus(menuParam);
        return ResponseEntityBuilder.buildNormalResponse(PageUtils.buildPage(menuParam.getPageNo(),
                menuParam.getPageSize(), menusCount, menus, null));
    }

    @Override
    public ResponseEntityDto<?> getMenus(MenuParam menuParam) {
        List<Menu> menus = menuMapper.getMenus(menuParam);

        menus.forEach(menu -> {

        });

        return null;
    }

    @Override
    public ResponseEntityDto<?> addMenu(Menu menu) {
        return null;
    }

    @Override
    public ResponseEntityDto<?> editMenu(Menu menu) {
        return null;
    }
}
