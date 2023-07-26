package com.dxz.web.house.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.web.house.entity.HouseBuild;
import com.dxz.web.house.param.HouseBuildParam;

/**
 * <p>
 * 楼栋表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
public interface IHouseBuildService extends IService<HouseBuild> {

    IPage<HouseBuild> getList(HouseBuildParam param);
}
