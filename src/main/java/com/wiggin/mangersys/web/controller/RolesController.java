package com.wiggin.mangersys.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiggin.mangersys.service.RolesService;
import com.wiggin.mangersys.web.vo.response.RoleTreeResponse;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author wiggin123
 * @since 2019-01-17
 */
@RestController
@RequestMapping("/role")
public class RolesController {
    
    @Autowired
    private RolesService roleService;
    
    @GetMapping("/list")
    public void list() {
        
    }
    
    @GetMapping("/tree")
    public List<RoleTreeResponse> getTree() {
        return roleService.getRolesTree();
    }
}

