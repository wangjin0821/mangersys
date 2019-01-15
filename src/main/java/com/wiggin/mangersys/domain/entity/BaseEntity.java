package com.wiggin.mangersys.domain.entity;

import java.util.Date;

public class BaseEntity {
	
	private Date createTime;
	
	private Date updateTime;
	
	public void setDefaultValue() {
		Date date = new Date();
		this.createTime = date;
		this.updateTime = date;
	}
}
