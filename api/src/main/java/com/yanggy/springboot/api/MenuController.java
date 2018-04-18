package com.yanggy.springboot.api;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.MenuParam;
import com.yanggy.springboot.entity.Menu;
import com.yanggy.springboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/18 15:44
 * @Description:
 */

@RestController
@RequestMapping("/menu/**")
public class MenuController {
    @Autowired
    private MenuService menuService;

    ResponseEntityDto<?> getMenusByPage(MenuParam menuParam) {
        return menuService.getMenusByPage(menuParam);
    }

    ResponseEntityDto<?> getMenus(MenuParam menuParam) {
        return menuService.getMenus(menuParam);
    }

    ResponseEntityDto<?> addMenu(Menu menu) {
        return menuService.addMenu(menu);
    }

    ResponseEntityDto<?> editMenu(Menu menu) {
        return menuService.editMenu(menu);
    }
}
