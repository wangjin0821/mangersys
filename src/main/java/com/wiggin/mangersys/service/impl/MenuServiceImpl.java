package com.wiggin.mangersys.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.google.common.collect.Lists;
import com.wiggin.mangersys.domain.entity.Menu;
import com.wiggin.mangersys.domain.mapper.MenuMapper;
import com.wiggin.mangersys.service.MenuService;
import com.wiggin.mangersys.web.vo.request.MenuSaveRequest;
import com.wiggin.mangersys.web.vo.response.MenuTreeResponse;

import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author wiggin
 * @since 2018-09-15
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<MenuTreeResponse> getMenuTree() {
        Wrapper<Menu> wrapper = new EntityWrapper<>();
        List<Menu> menuList = menuMapper.selectList(wrapper);
        log.info("menuList => {}", menuList);
        Map<Integer, List<Menu>> menuMap = menuList.parallelStream().collect(Collectors.groupingBy(Menu::getParentId));
        List<MenuTreeResponse> menuTrees = Lists.newArrayList();
        List<Menu> parentMenuList = menuMap.get(0);
        for (Menu menu : parentMenuList) {
            MenuTreeResponse menuTreeResponse = new MenuTreeResponse();
            BeanUtils.copyProperties(menu, menuTreeResponse);
            if (menuMap.containsKey(menu.getId())) {
                List<Menu> subMenuList = menuMap.get(menu.getId());
                List<MenuTreeResponse> menuTreesTemp = Lists.newArrayList();
                for (Menu subMenu : subMenuList) {
                    MenuTreeResponse menuTreeResponseTemp = new MenuTreeResponse();
                    BeanUtils.copyProperties(subMenu, menuTreeResponseTemp);
                    menuTreesTemp.add(menuTreeResponseTemp);
                }
                menuTreeResponse.setChildren(menuTreesTemp);
            }
            menuTrees.add(menuTreeResponse);
        }
        log.info("menuTrees => {}", menuTrees);
        return menuTrees;
    }


    @Override
    public Integer saveMenu(MenuSaveRequest menuReq) {
        Menu entity = new Menu();
        BeanUtils.copyProperties(menuReq, entity);
        if (entity.getId() != null && entity.getId() > 0) {
            return menuMapper.updateById(entity);
        } else {
            return menuMapper.insert(entity);
        }
        
    }


    @Override
    public Integer deleteMenu(List<Integer> menuIds) {
        return menuMapper.deleteBatchIds(menuIds);
    }

}
