package com.personalWebsite.dao;

import com.personalWebsite.entity.FileRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 文件关系 Repository
 * Created by xiatianlong on 2018/1/20.
 */
public interface FileRelationRepository extends JpaRepository<FileRelationEntity, String> {

    /**
     * 根据fileNo获取文件
     *
     * @param fileNo fileNo
     * @return User
     */
    FileRelationEntity findByFileNo(String fileNo);

}
