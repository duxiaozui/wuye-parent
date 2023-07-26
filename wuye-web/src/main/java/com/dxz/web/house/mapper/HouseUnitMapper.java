package com.dxz.web.house.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.web.house.entity.HouseUnit;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 单元表 Mapper 接口
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
public interface HouseUnitMapper extends BaseMapper<HouseUnit> {

    IPage<HouseUnit> getList(IPage<HouseUnit> page, @Param("buildName") String buildName, @Param("unitName") String unitName);
}
