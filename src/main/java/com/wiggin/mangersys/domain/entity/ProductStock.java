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
 * 产品库存信息表
 * </p>
 *
 * @author wiggin123
 * @since 2018-09-18
 */
@Data
@TableName("api_product_stock")
@AllArgsConstructor
@NoArgsConstructor
public class ProductStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 产品id
     */
    private Integer productId;
    /**
     * sku
     */
    private String sku;
    /**
     * 真实库存数量
     */
    private Integer realQuantity;
    /**
     * 在途库存
     */
    private Integer transQuantity;
    private Date createTime;
    private Date updateTime;


}
