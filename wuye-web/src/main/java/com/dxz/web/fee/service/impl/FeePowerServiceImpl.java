package com.dxz.web.fee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxz.web.fee.entity.FeePower;
import com.dxz.web.fee.mapper.FeePowerMapper;
import com.dxz.web.fee.param.FeePowerParam;
import com.dxz.web.fee.service.IFeePowerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电费表 服务实现类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
@Service
public class FeePowerServiceImpl extends ServiceImpl<FeePowerMapper, FeePower> implements IFeePowerService {
    @Override
    public IPage<FeePower> getList(FeePowerParam param) {
        IPage<FeePower> page = new Page<>(param.getCurrentPage(), param.getPageSize());
        return this.baseMapper.getList(page, param.getUsername(), param.getHouseNum());
    }

    @Override
    public void saveFeePower(FeePower feePower) {
        this.baseMapper.insert(feePower);
    }

    @Override
    public void updateFeePower(FeePower feePower) {
        this.baseMapper.updateById(feePower);
    }
}
