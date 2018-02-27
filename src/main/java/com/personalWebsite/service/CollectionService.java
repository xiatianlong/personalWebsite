package com.personalWebsite.service;

import com.personalWebsite.entity.CollectionEntity;

import java.util.List;

/**
 * 收藏Service.
 * Created by xiatianlong on 2018/2/26.
 */
public interface CollectionService extends BaseService {


    /**
     * 收藏处理
     *
     * @param bizType 业务类型
     * @param bizId   业务id
     * @throws Exception E
     */
    void doCollection(String bizType, String bizId) throws Exception;

    /**
     * 获取收藏
     *
     * @param bizType 业务类型
     * @param bizId   业务id
     * @param userId  userId
     * @return 收藏
     */
    CollectionEntity getCollection(String bizType, String bizId, String userId);

    /**
     * 删除收藏
     *
     * @param bizType 业务类型
     * @param bizId   业务id
     * @throws Exception e
     */
    void removeCollection(String bizType, String bizId) throws Exception;

    /**
     * 根据用户下全部的收藏
     *
     * @param userId userId
     * @return list
     */
    List<CollectionEntity> getCollectionsByUser(String userId);

}
