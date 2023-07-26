package com.dxz.web.house.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.web.house.entity.HouseList;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 房屋表 Mapper 接口
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
public interface HouseListMapper extends BaseMapper<HouseList> {

    IPage<HouseList> getList(
            IPage<HouseList> page,
            @Param("buildName") String buildName,
            @Param("unitName") String unitName,
            @Param("houseNum") String houseNum,
            @Param("status") Integer status);
}
