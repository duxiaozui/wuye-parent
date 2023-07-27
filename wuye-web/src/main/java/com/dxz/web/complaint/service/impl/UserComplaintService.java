package com.dxz.web.complaint.service.impl;

import com.dxz.web.complaint.param.UserComplaintParam;
import com.dxz.web.complaint.po.UserComplaint;

import java.util.Map;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/24/27(星期四) 10:24
 * request：
 */

public interface UserComplaintService {
    Map<String, Object> list(UserComplaintParam param);

    Map<String, Object> myList(UserComplaintParam param);

    void save(UserComplaint userComplaint);

    void update(UserComplaint userComplaint);

    void delete(String id);

}