package com.yanggy.springboot.dto.in;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2018/4/18 15:58
 * @Description:
 */

@Data
public class MenuParam extends BaseParam implements Serializable {
    private Long parentId;
}
