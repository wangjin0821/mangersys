package com.wiggin.mangersys.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiggin.mangersys.service.MenuService;
import com.wiggin.mangersys.web.vo.request.MenuSaveRequest;
import com.wiggin.mangersys.web.vo.response.MenuTreeResponse;

import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author wiggin123
 * @since 2018-09-15
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("/list")
    @ApiOperation("菜单列表")
    public List<MenuTreeResponse> getList() {
        return menuService.getMenuTree();
    }


    @PostMapping("/save")
    @ApiOperation("保存菜单")
    public Integer save(@RequestBody MenuSaveRequest menuReq) {
        return menuService.saveMenu(menuReq);
    }
    
    
    @PostMapping("/delete")
    @ApiOperation("删除菜单")
    public Integer delete(@RequestBody List<Integer> ids) {
        return menuService.deleteMenu(ids);
    }
}
