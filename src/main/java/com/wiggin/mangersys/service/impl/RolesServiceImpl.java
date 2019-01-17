package com.wiggin.mangersys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.wiggin.mangersys.domain.entity.Roles;
import com.wiggin.mangersys.domain.mapper.RolesMapper;
import com.wiggin.mangersys.service.RolesService;
import com.wiggin.mangersys.web.vo.response.RoleTreeResponse;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author wiggin123
 * @since 2019-01-17
 */
@Service
public class RolesServiceImpl implements RolesService {
    
    private RolesMapper roleMapper;

    @Override
    public List<RoleTreeResponse> getRolesTree() {
        Wrapper<Roles> wrapper = new EntityWrapper<>();
        List<Roles> roleList = roleMapper.selectList(wrapper);
        
        return null;
    }

}
