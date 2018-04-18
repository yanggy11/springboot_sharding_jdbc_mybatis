package com.yanggy.springboot.api;

import com.yanggy.springboot.common.ResponseEntityDto;
import com.yanggy.springboot.dto.in.MenuParam;
import com.yanggy.springboot.entity.Menu;
import com.yanggy.springboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "getMenusByPage")
    ResponseEntityDto<?> getMenusByPage(@RequestBody MenuParam menuParam) {
        return menuService.getMenusByPage(menuParam);
    }

    @PostMapping(value = "getMenus")
    ResponseEntityDto<?> getMenus(@RequestBody MenuParam menuParam) {
        return menuService.getMenus(menuParam);
    }

    @PostMapping(value = "addMenu")
    ResponseEntityDto<?> addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    @PutMapping(value = "editMenu")
    ResponseEntityDto<?> editMenu(@RequestBody Menu menu) {
        return menuService.editMenu(menu);
    }
}
