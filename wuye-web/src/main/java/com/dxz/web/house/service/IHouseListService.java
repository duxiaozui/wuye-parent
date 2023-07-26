package com.dxz.web.house.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.web.house.entity.HouseList;
import com.dxz.web.house.param.HouseListParam;

/**
 * <p>
 * 房屋表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
public interface IHouseListService extends IService<HouseList> {

    IPage<HouseList> getList(HouseListParam param);
}
