package com.dxz.web.repair.dao;

import com.dxz.web.repair.po.UserRepair;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/27/28(星期五) 17:27
 * request：
 */
public interface UserRepairDao extends MongoRepository<UserRepair, String> {
}
