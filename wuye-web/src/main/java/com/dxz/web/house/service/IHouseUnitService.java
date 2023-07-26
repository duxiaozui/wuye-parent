package com.dxz.web.house.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.web.house.entity.HouseUnit;
import com.dxz.web.house.param.HouseUnitParam;

/**
 * <p>
 * 单元表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
public interface IHouseUnitService extends IService<HouseUnit> {

    IPage<HouseUnit> getList(HouseUnitParam param);
}
