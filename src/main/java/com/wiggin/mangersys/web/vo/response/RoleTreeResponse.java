package com.wiggin.mangersys.web.vo.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleTreeResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3202672141541218001L;
    
    private Integer id;
    private Integer parentId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色code
     */
    private String roleCode;

    
    private List<RoleTreeResponse> children;
}
