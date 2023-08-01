package com.dxz.web.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dxz.web.system.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
//@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<String> getMenus(Integer userId);
}
