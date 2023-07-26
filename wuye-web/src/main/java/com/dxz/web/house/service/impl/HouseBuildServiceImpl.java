package com.dxz.web.house.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxz.web.house.entity.HouseBuild;
import com.dxz.web.house.mapper.HouseBuildMapper;
import com.dxz.web.house.param.HouseBuildParam;
import com.dxz.web.house.service.IHouseBuildService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * <p>
 * 楼栋表 服务实现类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
@Service
public class HouseBuildServiceImpl extends ServiceImpl<HouseBuildMapper, HouseBuild> implements IHouseBuildService {
    @Override
    public IPage<HouseBuild> getList(HouseBuildParam param) {
        String buildName = param.getBuildName();
        Integer type = param.getType();
        //构建分页对象
        IPage<HouseBuild> page = new Page<>(param.getCurrentPage(), param.getPageSize());
        //构建查询条件
        LambdaQueryWrapper<HouseBuild> query = new LambdaQueryWrapper();
        if (StringUtils.hasText(buildName)) {
            query.like(HouseBuild::getBuildName, buildName);
        }
        if (!Objects.isNull(type)) {
            query.eq(HouseBuild::getType, type);
        }
        return this.baseMapper.selectPage(page, query);
    }
}
