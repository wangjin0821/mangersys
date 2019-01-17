package com.wiggin.mangersys.util;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.wiggin.mangersys.domain.entity.TreeEntity;
import com.wiggin.mangersys.web.vo.response.MenuTreeResponse;
import com.wiggin.mangersys.web.vo.response.TreeBaseResponse;


public class TreeUtil {

    public static <K, T extends TreeEntity, R extends TreeBaseResponse> List<R> createTree(Class<R> clazz, List<T> dataList, K key, Function<T, K> groupFunc) {
        Map<K, List<T>> dataMap = dataList.parallelStream().collect(Collectors.groupingBy(groupFunc));
        List<R> treeList = Lists.newArrayList();
        List<T> parentList = dataMap.get(key);
        for (T parent : parentList) {
            try {
				R treeResponse = clazz.newInstance();
				BeanUtils.copyProperties(parent, treeResponse);
				if (dataMap.containsKey(parent.getId())) {
					treeResponse.setChildren(TreeUtil.getTreeChild(MenuTreeResponse.class, dataMap.get(parent.getId()), dataMap));
	            }
				treeList.add(treeResponse);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
        }
        return treeList;
    }
    
    
	public static <K, T extends TreeEntity, R extends TreeBaseResponse> List<R> getTreeChild(Class<R> clazz, List<T> dataList, Map<K, List<T>> dataMap) {
        List<R> returnList = Lists.newArrayList();
        for (T t : dataList) {
            R treeResponse;
			try {
				treeResponse = clazz.newInstance();
				BeanUtils.copyProperties(t, treeResponse);
	            if (dataMap.containsKey(t.getId())) {
	                List<R> menuChild = getTreeChild(clazz, dataMap.get(t.getId()), dataMap);
	                treeResponse.setChildren(menuChild);
	            }
	            returnList.add(treeResponse);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
        }
        return returnList;
    }
    
}
