package com.dxz.service.impl;

import com.dxz.entity.LiveUser;
import com.dxz.mapper.LiveUserMapper;
import com.dxz.service.ILiveUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业主表 服务实现类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
@Service
public class LiveUserServiceImpl extends ServiceImpl<LiveUserMapper, LiveUser> implements ILiveUserService {

}
