package com.dxz.web.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.web.system.entity.LiveUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 业主表 Mapper 接口
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
//@Mapper
public interface LiveUserMapper extends BaseMapper<LiveUser> {


    IPage<LiveUser> getList(IPage<LiveUser> page, @Param("trueName") String trueName, @Param("phone") String phone);

    LiveUser getUser(@Param("userId") Integer userId);

    List<String> getMenus(Integer userId);
}
