package com.wiggin.mangersys.config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = -2043238647910377588L;

	private Integer code;
    
	public CustomException(ExceptionCodeEnum codeEnum) {
		super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }
}
