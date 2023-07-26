package com.dxz.web.fee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.web.fee.entity.FeePower;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 电费表 Mapper 接口
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
public interface FeePowerMapper extends BaseMapper<FeePower> {

    IPage<FeePower> getList(IPage<FeePower> page, @Param("username") String username, @Param("houseNum") String houseNum);
}
