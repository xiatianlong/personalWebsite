package com.personalWebsite.service;

import com.personalWebsite.common.mail.MailInfo;
import com.personalWebsite.common.mail.MailSender;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.dao.EmailRecordRepository;
import com.personalWebsite.entity.EmailRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by xiatianlong on 2018/1/5.
 */
@Service
@EnableAsync
@Transactional(readOnly = true)
public class EmailRecordServiceImpl extends BaseServiceImpl implements EmailRecordService {

    @Autowired
    private EmailRecordRepository emailRecordRepository;

    @Autowired
    private MailSender mailSender;

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

    /**
     * 获取未发送的邮件
     */
    @Override
    public List<EmailRecordEntity> getUnsendEmailList() {
        return emailRecordRepository.findBySuccessFalse();
    }

    /**
     * 异步发送邮件
     *
     * @param entity 邮件实体
     */
    @Transactional
    public void sendEmail(EmailRecordEntity entity) {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setMailCode(entity.getEmailCode());
        mailInfo.setTo(entity.getEmailTo());
        mailInfo.setSubject(entity.getEmailSubject());
        mailInfo.setContent(entity.getEmailContent());
        boolean isSuccess = mailSender.sendMail(mailInfo);
        if (isSuccess) {
            Date now = new Date();
            entity.setSuccess(true);
            entity.setSendSuccessTime(now);
            entity.setUpdateTime(now);
            entity.setUpdateUser(Constant.ADMIN);
            emailRecordRepository.saveAndFlush(entity);
        }
    }
}

