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
 * 产品图片信息表
 * </p>
 *
 * @author wiggin123
 * @since 2018-09-18
 */
@Data
@TableName("api_product_picture")
@AllArgsConstructor
@NoArgsConstructor
public class ProductPicture implements Serializable {

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
     * 图片路径
     */
    private String picturePath;
    private Date createTime;
    private Date updateTime;
    /**
     * 图片类型,1主图，2附属图
     */
    private Integer pictureType;


}
