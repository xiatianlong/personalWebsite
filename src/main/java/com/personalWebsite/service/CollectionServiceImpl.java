package com.personalWebsite.service;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.enums.BizType;
import com.personalWebsite.common.enums.NoteStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.dao.CollectionRepository;
import com.personalWebsite.dictionary.DictionaryCache;
import com.personalWebsite.entity.ArticleEntity;
import com.personalWebsite.entity.CollectionEntity;
import com.personalWebsite.entity.DictionaryEntity;
import com.personalWebsite.entity.NoteEntity;
import com.personalWebsite.model.response.collection.CollectionInfo;
import com.personalWebsite.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 收藏服务类
 * Created by xiatianlong on 2018/2/26.
 */
@Service
@Transactional(readOnly = true)
public class CollectionServiceImpl extends BaseServiceImpl implements CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    /**
     * 收藏处理
     *
     * @param bizType 业务类型
     * @param bizId   业务id
     * @throws Exception E
     */
    @Override
    @Transactional
    public void doCollection(String bizType, String bizId) throws Exception {
        // 校验业务类型是否存在
        List<DictionaryEntity> dictionaryEntityList = DictionaryCache.getChildList("001");
        if (dictionaryEntityList == null || dictionaryEntityList.isEmpty()) {
            throw new ApplicationException(getMessage("enums.child.list.null", new Object[]{"001"}));
        }
        boolean bizTypeExist = false;
        for (DictionaryEntity dictionaryEntity : dictionaryEntityList) {
            if (dictionaryEntity.getDicCode().equals(bizType)) {
                bizTypeExist = true;
            }
        }
        if (!bizTypeExist) {
            throw new ApplicationException(getMessage("bizType.not.exist"));
        }
        // 检查是否已收藏
        CollectionEntity tempCollectionEntity = getCollection(bizType, bizId, getLoinUser().getUserId());
        if (tempCollectionEntity != null) {
            throw new ApplicationException(getMessage("collection.exist", new Object[]{DictionaryCache.getName(bizType)}));
        }

        Date now = new Date();

        // 持久化收藏数据
        CollectionEntity collectionEntity = new CollectionEntity();
        collectionEntity.setBizId(bizId);
        collectionEntity.setBizType(bizType);
        collectionEntity.setUserId(getLoinUser().getUserId());
        collectionEntity.setDeleted(false);
        collectionEntity.setCreateTime(now);
        collectionEntity.setUpdateTime(now);
        collectionEntity.setCreateUser(getLoinUser().getUserId());
        collectionEntity.setUpdateUser(getLoinUser().getUserId());
        collectionRepository.save(collectionEntity);
    }

    /**
     * 获取收藏
     *
     * @param bizType 业务类型
     * @param bizId   业务id
     * @param userId  userId
     * @return 收藏
     */
    @Override
    public CollectionEntity getCollection(String bizType, String bizId, String userId) {
        return collectionRepository.getCollection(bizType, bizId, userId);
    }

    /**
     * 删除收藏
     *
     * @param bizType 业务类型
     * @param bizId   业务id
     * @throws Exception e
     */
    @Transactional
    @Override
    public void removeCollection(String bizType, String bizId) throws Exception {
        CollectionEntity collectionEntity = getCollection(bizType, bizId, getLoinUser().getUserId());
        if (collectionEntity == null) {
            throw new ApplicationException(getMessage("collection.not.exist", new Object[]{DictionaryCache.getName(bizType)}));
        }
        collectionEntity.setDeleted(true);
        collectionEntity.setUpdateTime(new Date());
        collectionEntity.setUpdateUser(getLoinUser().getUserId());
        collectionRepository.saveAndFlush(collectionEntity);
    }

    /**
     * 根据用户下全部的收藏
     *
     * @param userId userId
     * @return list
     */
    @Override
    public List<CollectionEntity> getCollectionsByUser(String userId) {
        return collectionRepository.getCollectionsByUser(userId);
    }

    /**
     * 根据BIZ_TYPE分组收藏信息
     *
     * @return map
     */
    @Override
    public Map<String, List<CollectionInfo>> getCollectionGroupByBizType(List<CollectionEntity> collectionEntities) {

        if (collectionEntities == null || collectionEntities.isEmpty()) {
            return null;
        }

        Map<String, List<CollectionInfo>> map = new HashMap<>();

        for (CollectionEntity collectionEntity : collectionEntities) {
            List<CollectionInfo> collectionInfos = map.get(DictionaryCache.getName(collectionEntity.getBizType()));
            if (collectionInfos == null) {
                // type不存在  插入新的type
                List<CollectionInfo> infos = new ArrayList<>();
                infos.add(buildInfo(collectionEntity));
                map.put(DictionaryCache.getName(collectionEntity.getBizType()), infos);
            } else {
                // 存在，插入新的type值
                collectionInfos.add(buildInfo(collectionEntity));
            }
        }

        return map;
    }


    /**
     * 封装收藏信息
     *
     * @param collectionEntity 收藏实体
     * @return info
     */
    private CollectionInfo buildInfo(CollectionEntity collectionEntity) {
        if (collectionEntity == null) {
            return null;
        }
        CollectionInfo info = new CollectionInfo();
        // 业务id
        info.setBizId(collectionEntity.getBizId());
        // 业务类型
        info.setBizType(collectionEntity.getBizType());
        // 用户id
        info.setUserId(collectionEntity.getUserId());
        // 用户名称
        info.setUserName(collectionEntity.getUserEntity().getUserName());
        if (BizType.ARTICLE.getCode().equals(collectionEntity.getBizType())) {
            // 收藏内容标题
            ArticleEntity articleEntity = collectionEntity.getArticleEntity();
            if (articleEntity != null) {
                info.setTitle(articleEntity.getArticleTitle());
                // 收藏内容是否删除
                info.setDeleted(articleEntity.isDeleted());
                // 收藏内容在前端是否可显示
                info.setVisible(!articleEntity.isDeleted() && ArticleStatus.REVIEW_PASSED.getCode().equals(articleEntity.getArticleStatus()));

            }

        } else if (BizType.NOTE.getCode().equals(collectionEntity.getBizType())) {
            // 收藏内容标题
            NoteEntity noteEntity = collectionEntity.getNoteEntity();
            if (noteEntity != null) {
                info.setTitle(noteEntity.getNoteTitle());
                // 收藏内容是否删除
                info.setDeleted(noteEntity.isDeleted());
                // 收藏内容在前端是否可显示
                info.setVisible(!noteEntity.isDeleted() && NoteStatus.REVIEW_PASSED.getCode().equals(noteEntity.getNoteStatus()));
            }
        }
        // 收藏时间
        info.setCreateTime(DateUtil.defaultFormat(collectionEntity.getCreateTime()));
        return info;
    }

}
