package com.wiggin.mangersys.service;

import java.util.List;

import com.wiggin.mangersys.web.vo.response.RoleTreeResponse;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author wiggin123
 * @since 2019-01-17
 */
public interface RolesService {

    List<RoleTreeResponse> getRolesTree();
}
