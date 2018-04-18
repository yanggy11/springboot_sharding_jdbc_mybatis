package com.yanggy.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/18 14:53
 * @Description:
 */

@Data
public class Menu extends BaseEntity implements Serializable {
    private Long id;
    private String menu;
    private String menuName;
    private Long parentId;
    private String icon;
    private List<Menu> childrens = new ArrayList<>();
}
