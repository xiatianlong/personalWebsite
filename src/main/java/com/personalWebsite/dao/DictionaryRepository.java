package com.personalWebsite.dao;

import com.personalWebsite.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 邮箱记录 Repository
 * Created by xiatianlong on 2018/1/5.
 */
public interface DictionaryRepository extends JpaRepository<DictionaryEntity, String> {

    /**
     * 查询字典全部数据
     *
     * @return 字典
     */
    List<DictionaryEntity> findAll();


}
