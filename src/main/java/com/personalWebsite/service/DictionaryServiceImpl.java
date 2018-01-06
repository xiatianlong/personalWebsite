package com.personalWebsite.service;

import com.personalWebsite.dao.DictionaryRepository;
import com.personalWebsite.entity.DictionaryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字典表服务类.
 * Created by xiatianlong on 2018/1/6.
 */
@Service
@Transactional(readOnly = true)
public class DictionaryServiceImpl extends BaseServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public List<DictionaryEntity> findAll() {
        return dictionaryRepository.findAll();
    }
}
