package com.personalWebsite.job;

import com.personalWebsite.entity.EmailRecordEntity;
import com.personalWebsite.service.EmailRecordService;
import com.personalWebsite.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 邮件发送JOB
 * Created by xiatianlong on 2018/1/5.
 */

public class EmailSendJob {

    @Autowired
    private EmailRecordService emailRecordService;

    /**
     * 邮件发送处理
     */
    public void execute() {
        // 是否开启邮件发送
        Boolean isOpenEmail = Boolean.parseBoolean(PropertiesUtil.getProperty("is_open_email"));
        if (isOpenEmail) {
            List<EmailRecordEntity> recordEntityList = emailRecordService.getUnsendEmailList();
            if (recordEntityList != null && !recordEntityList.isEmpty()) {
                for (EmailRecordEntity email : recordEntityList) {
                    emailRecordService.sendEmail(email);
                }
            }
        }
    }

}