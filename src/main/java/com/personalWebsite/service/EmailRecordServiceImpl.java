package com.personalWebsite.service;

import com.personalWebsite.dao.EmailRecordRepository;
import com.personalWebsite.entity.EmailRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiatianlong on 2018/1/5.
 */
@Service
@Transactional(readOnly = true)
public class EmailRecordServiceImpl extends BaseServiceImpl implements EmailRecordService {

    @Autowired
    private EmailRecordRepository emailRecordRepository;

    /**
     * 保存邮件记录
     *
     * @param emailRecordEntity 邮件记录实体
     */
    @Transactional
    @Override
    public void saveEmailRecord(EmailRecordEntity emailRecordEntity) {
        emailRecordRepository.save(emailRecordEntity);
    }
}
