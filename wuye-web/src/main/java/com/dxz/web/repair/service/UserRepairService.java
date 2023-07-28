package com.dxz.web.repair.service;

import com.dxz.web.repair.param.UserRepairParam;
import com.dxz.web.repair.po.UserRepair;

import java.util.Map;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/25/28(星期五) 17:25
 * request：
 */
public interface UserRepairService {
    Map<String, Object> getList(UserRepairParam param);

    Map<String, Object> myList(UserRepairParam param);

    void addRepair(UserRepair userRepair);

    void updateRepair(UserRepair userRepair);

    void deleteRepair(String id);
}