package com.dxz.web.complaint.dao;

import com.dxz.web.complaint.po.UserComplaint;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/23/27(星期四) 10:23
 * request：只要编写接口继承MongoRepository，框架就会未我们生成有crud操作的实现类，并注入容器中
 */


public interface UserComplaintDao extends MongoRepository<UserComplaint, String> {

}