package com.dxz.web.fee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.web.fee.entity.FeeWater;
import com.dxz.web.fee.param.FeeWaterParam;

/**
 * <p>
 * 水费表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
public interface IFeeWaterService extends IService<FeeWater> {

    IPage<FeeWater> getList(FeeWaterParam param);

    void saveFeeWater(FeeWater feeWater);

    void updateFeeWater(FeeWater feeWater);
}
