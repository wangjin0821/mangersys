package com.wiggin.mangersys.util;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;


public class Util {

    public static <K, T, R> List<R> createTree(List<T> dataList, K key, Function<T, K> groupFunc) {
        Map<K, List<T>> dataMap = dataList.parallelStream().collect(Collectors.groupingBy(groupFunc));
        List<R> treeList = Lists.newArrayList();
        List<T> parentList = dataMap.get(key);
        for (T parent : parentList) {
            
        }
        /*List<Menu> parentMenuList = menuMap.get(0);
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
        }*/
        return treeList;
    }
    
    
    public static <K, T, R> List<R> getTreeChild(List<T> dataList, Map<K, List<T>> dataMap) {
        List<R> returnList = Lists.newArrayList();
        
        return returnList;
    }
    
}
