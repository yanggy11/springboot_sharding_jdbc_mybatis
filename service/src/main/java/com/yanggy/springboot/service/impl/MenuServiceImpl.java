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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/18 15:53
 * @Description:
 */

@Service
@Transactional
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
        List<Menu> menuList = menuMapper.getMenus(menuParam);

        menuList.forEach(menu -> {
            for(Menu menu1 : menuList) {
                if(menu.getId().equals(menu1.getParentId())) {
                    menu.getChildrens().add(menu1);
                }
            }
        });

        List<Menu> menus = menuList.stream().
                filter(menu -> menu.getParentId() == -1).
                collect(Collectors.toList());

        return ResponseEntityBuilder.buildNormalResponse(menus);
    }

    @Override
    public ResponseEntityDto<?> addMenu(Menu menu) {
        menuMapper.addMenu(menu);
        return ResponseEntityBuilder.buildNormalResponse();
    }

    @Override
    public ResponseEntityDto<?> editMenu(Menu menu) {
        menuMapper.editMenu(menu);
        return ResponseEntityBuilder.buildNormalResponse();
    }
}
