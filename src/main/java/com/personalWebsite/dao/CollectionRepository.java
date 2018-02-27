package com.personalWebsite.dao;

import com.personalWebsite.entity.CollectionEntity;
import com.personalWebsite.entity.id.CollectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 收藏 Repository
 * Created by xiatianlong on 2018/2/26.
 */
public interface CollectionRepository extends JpaRepository<CollectionEntity, CollectionId> {


    /**
     * 获取收藏
     *
     * @param bizType 业务类型
     * @param bizId   业务id
     * @param userId  useriId
     * @return 收藏
     */
    @Query(value = "SELECT * FROM t_collection collection" +
            " WHERE collection.BIZ_TYPE = ?1 " +
            "AND collection.BIZ_ID = ?2 " +
            "AND collection.USER_ID = ?3 " +
            "AND collection.IS_DELETE = 0", nativeQuery = true)
    CollectionEntity getCollection(String bizType, String bizId, String userId);

    /**
     * 获取用户收藏列表
     *
     * @param userId userId
     * @return list
     */
    @Query(value = "SELECT * FROM t_collection collection WHERE collection.USER_ID = ?1 AND collection.IS_DELETE = 0", nativeQuery = true)
    List<CollectionEntity> getCollectionsByUser(String userId);

}
