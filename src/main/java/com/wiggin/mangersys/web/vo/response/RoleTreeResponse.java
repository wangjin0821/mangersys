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
public class RoleTreeResponse extends TreeBaseResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3202672141541218001L;
    
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色code
     */
    private String roleCode;

}
