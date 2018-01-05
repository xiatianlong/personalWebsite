package com.personalWebsite.service;

import com.personalWebsite.entity.EmailRecordEntity;

/**
 * 邮件记录服务类.
 * Created by xiatianlong on 2018/1/5.
 */
public interface EmailRecordService extends BaseService {

    /**
     * 保存邮件记录
     *
     * @param emailRecordEntity 邮件记录实体
     */
    void saveEmailRecord(EmailRecordEntity emailRecordEntity);

}
