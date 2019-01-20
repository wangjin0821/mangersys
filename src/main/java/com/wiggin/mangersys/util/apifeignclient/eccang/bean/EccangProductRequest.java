package com.wiggin.mangersys.util.apifeignclient.eccang.bean;

import java.util.Date;

import lombok.Data;

@Data
public class EccangProductRequest {
	
	private String productSku;
	private String productSkuLike;
	
	private String productTitle;
	private String productTitleLike;
	
	private Date productAddTimeFrom;
	private Date productAddTimeTo;
	
	private Date productUpdateTimeFrom;
	private Date productUpdateTimeTo;
	
	private Integer isCombination;
	private Integer getProductCombination;
	
	private Integer getProductBox;
	
	private Integer getProperty;
	
	private Integer getProductCustomCategory;
	
	private Integer page;
	
	private Integer pageSize;
	
}
