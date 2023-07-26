package com.dxz.web.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.web.system.entity.LiveUser;
import com.dxz.web.system.param.AssignHouseParam;
import com.dxz.web.system.param.LiveUserParam;

/**
 * <p>
 * 业主表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
public interface ILiveUserService extends IService<LiveUser> {

    IPage<LiveUser> getList(LiveUserParam param);

    void saveLiveUser(LiveUser liveUser);

    void editLiveUser(LiveUser liveUser);

    LiveUser getUser(Integer userId);

    void assignHouse(AssignHouseParam param);
}
