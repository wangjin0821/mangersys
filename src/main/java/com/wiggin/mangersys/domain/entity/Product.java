package com.wiggin.mangersys.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品主信息表
 * </p>
 *
 * @author wiggin123
 * @since 2018-09-18
 */
@Data
@Accessors(chain = true)
@TableName("api_product")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * sku
     */
    private String sku;
    /**
     * 名称
     */
    private String cnName;
    /**
     * 重量
     */
    private BigDecimal weight;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 供应商名称
     */
    private String supplierName;
    
    /**
     * 供应商产品详情链接
     */
    private String skuLink;
    
    private Date createTime;
    
    
    private Date updateTime;
    
    /**
     * 销量
     */
    private Integer salesVolume;

    /**
     * 是否删除
     */
    private Integer isDeleted;
}
