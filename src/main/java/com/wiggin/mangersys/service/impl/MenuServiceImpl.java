package com.wiggin.mangersys.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.Lists;
import com.wiggin.mangersys.config.CustomException;
import com.wiggin.mangersys.config.ExceptionCodeEnum;
import com.wiggin.mangersys.domain.entity.Menu;
import com.wiggin.mangersys.domain.mapper.MenuMapper;
import com.wiggin.mangersys.service.MenuService;
import com.wiggin.mangersys.util.TreeUtil;
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
        if (CollectionUtils.isEmpty(menuList)) {
        	throw new CustomException(ExceptionCodeEnum.MENU_EMPTY);
        }
        List<MenuTreeResponse> menuTrees = TreeUtil.createTree(MenuTreeResponse.class, menuList, 0, Menu::getParentId);
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
