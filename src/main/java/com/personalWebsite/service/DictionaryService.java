package com.personalWebsite.service;

import com.personalWebsite.entity.DictionaryEntity;

import java.util.List;

/**
 * Dictionary Service.
 * Created by xiatianlong on 2018/1/6.
 */
public interface DictionaryService extends BaseService {

    /**
     * 查询全部字典
     */
    List<DictionaryEntity> findAll();

}
