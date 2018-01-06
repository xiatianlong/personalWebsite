package com.personalWebsite.dao;

import com.personalWebsite.entity.EmailRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 邮箱记录 Repository
 * Created by xiatianlong on 2018/1/5.
 */
public interface EmailRecordRepository extends JpaRepository<EmailRecordEntity, String> {

    /**
     * 查询未发送的邮件集合
     *
     * @return 邮件记录集合
     */
    List<EmailRecordEntity> findBySuccessFalse();

    /**
     * 根据emailCode 查询邮件记录
     *
     * @param emailCode emailCode
     * @return 邮件记录
     */
    EmailRecordEntity findByEmailCode(String emailCode);
}
