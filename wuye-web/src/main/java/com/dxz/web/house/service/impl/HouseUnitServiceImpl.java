package com.dxz.web.house.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxz.web.house.entity.HouseUnit;
import com.dxz.web.house.mapper.HouseUnitMapper;
import com.dxz.web.house.param.HouseUnitParam;
import com.dxz.web.house.service.IHouseUnitService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单元表 服务实现类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
@Service
public class HouseUnitServiceImpl extends ServiceImpl<HouseUnitMapper, HouseUnit> implements IHouseUnitService {

    @Override
    public IPage<HouseUnit> getList(HouseUnitParam param) {
        //构造分页对象
        IPage<HouseUnit> page = new Page<>(param.getCurrentPage(), param.getPageSize());
        return this.baseMapper.getList(page, param.getBuildName(), param.getUnitName());
    }
}
