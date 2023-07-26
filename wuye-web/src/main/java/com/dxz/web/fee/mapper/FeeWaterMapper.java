package com.dxz.web.fee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.web.fee.entity.FeeWater;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 水费表 Mapper 接口
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
public interface FeeWaterMapper extends BaseMapper<FeeWater> {

    IPage<FeeWater> getList(
            IPage<FeeWater> page,
            @Param("username") String username,
            @Param("houseNum") String houseNum);
}
