package com.dxz.web.fee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.web.fee.entity.FeePower;
import com.dxz.web.fee.param.FeePowerParam;

/**
 * <p>
 * 电费表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
public interface IFeePowerService extends IService<FeePower> {


    IPage<FeePower> getList(FeePowerParam param);

    void saveFeePower(FeePower feePower);

    void updateFeePower(FeePower feePower);
}
