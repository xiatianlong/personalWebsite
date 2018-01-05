package com.personalWebsite.dao;

import com.personalWebsite.entity.EmailRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 邮箱记录 Repository
 * Created by xiatianlong on 2018/1/5.
 */
public interface EmailRecordRepository extends JpaRepository<EmailRecordEntity, String> {

}
