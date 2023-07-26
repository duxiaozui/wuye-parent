package com.dxz.web.fee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxz.web.fee.entity.FeeWater;
import com.dxz.web.fee.mapper.FeeWaterMapper;
import com.dxz.web.fee.param.FeeWaterParam;
import com.dxz.web.fee.service.IFeeWaterService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 水费表 服务实现类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
@Service
public class FeeWaterServiceImpl extends ServiceImpl<FeeWaterMapper, FeeWater> implements IFeeWaterService {
    @Override
    public IPage<FeeWater> getList(FeeWaterParam param) {
        IPage<FeeWater> page = new Page<>(param.getCurrentPage(), param.getPageSize());
        return this.baseMapper.getList(page, param.getUsername(), param.getHouseNum());
    }

    @Override
    public void saveFeeWater(FeeWater feeWater) {
        this.baseMapper.insert(feeWater);
    }

    @Override
    public void updateFeeWater(FeeWater feeWater) {
        this.baseMapper.updateById(feeWater);
    }
}
