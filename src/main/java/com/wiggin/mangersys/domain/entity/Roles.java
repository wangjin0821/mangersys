package com.wiggin.mangersys.domain.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author wiggin123
 * @since 2019-01-17
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@TableName("api_roles")
public class Roles extends TreeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色code
     */
    private String roleCode;
    private Date createTime;
    private Date modifyTime;


}
