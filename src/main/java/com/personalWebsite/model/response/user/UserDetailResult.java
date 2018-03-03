package com.personalWebsite.model.response.user;

import com.personalWebsite.model.response.AsynchronousResult;

/**
 * 用户详情返回结果
 * Created by xiatianlong on 2018/3/1.
 */
public class UserDetailResult extends AsynchronousResult {

    /**
     * 用户详情
     */
    private UserDetail userDetail;


    /**
     * 获取 用户详情
     */
    public UserDetail getUserDetail() {
        return this.userDetail;
    }

    /**
     * 设置 用户详情
     */
    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
