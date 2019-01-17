package com.wiggin.mangersys.web.vo.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class MenuTreeResponse extends TreeBaseResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3202672141541218001L;
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
}
