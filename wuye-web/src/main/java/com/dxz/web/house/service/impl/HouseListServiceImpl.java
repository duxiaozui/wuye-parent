package com.dxz.web.house.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxz.web.house.entity.HouseList;
import com.dxz.web.house.mapper.HouseListMapper;
import com.dxz.web.house.param.HouseListParam;
import com.dxz.web.house.service.IHouseListService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 房屋表 服务实现类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
@Service
public class HouseListServiceImpl extends ServiceImpl<HouseListMapper, HouseList> implements IHouseListService {

    @Override
    public IPage<HouseList> getList(HouseListParam param) {
        //构造分页对象
        IPage<HouseList> page = new Page<>(param.getCurrentPage(), param.getPageSize());

        return this.baseMapper.getList(page, param.getBuildName(), param.getUnitName(), param.getHouseNum(), param.getStatus());
    }
}
