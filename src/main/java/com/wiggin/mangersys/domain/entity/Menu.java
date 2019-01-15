package com.wiggin.mangersys.domain.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author wiggin123
 * @since 2018-09-15
 */
@Data
@TableName("api_menu")
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer parentId;
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
    private Integer isShow;
    /**
     * 菜单层级
     */
    private Integer level;
    private Date createTime;
    private Date modifyTime;


}
