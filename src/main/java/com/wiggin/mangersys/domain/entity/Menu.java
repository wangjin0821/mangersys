package com.wiggin.mangersys.domain.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author wiggin123
 * @since 2018-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("api_menu")
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends TreeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单路径
     */
    private String path;
    /**
     * 图标的class
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否显示
     */
    private String isShow;
    /**
     * 菜单层级
     */
    private Integer level;
    private Date createTime;
    private Date modifyTime;


}
