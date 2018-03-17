package com.personalWebsite.dao;

import com.personalWebsite.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 评论 Repository
 * Created by xiatianlong on 2018/1/5.
 */
public interface CommentRepository extends JpaRepository<CommentEntity, String>, JpaSpecificationExecutor<CommentEntity> {


    /**
     * 获取热评用户
     *
     * @return list
     */
    @Query(value = "SELECT *\n" +
            "FROM (\n" +
            "  SELECT\n" +
            "  tc.COMMENT_USER_ID,\n" +
            "  COUNT(tc.COMMENT_ID) AS COUNT,\n" +
            "  tu.USER_NAME,\n" +
            "  tu.USER_HEAD_IMG_LARGE,\n" +
            "  tu.USER_HEAD_IMG_SMALL\n" +
            "FROM t_comment tc\n" +
            "  LEFT JOIN t_user tu ON tc.COMMENT_USER_ID = tu.USER_ID\n" +
            "GROUP BY tc.COMMENT_USER_ID\n" +
            ") t ORDER BY t.COUNT DESC LIMIT 5", nativeQuery = true)
    List<Object[]> getHotCommentUser();

    /**
     * 查询全部留言数
     *
     * @return 留言数
     */
    @Query(value = "SELECT COUNT(tc.COMMENT_ID) FROM t_comment tc", nativeQuery = true)
    long getAllCommentCnt();

    /**
     * 根据业务类型查询留言数
     *
     * @return 留言数
     */
    @Query(value = "SELECT COUNT(tc.COMMENT_ID) FROM t_comment tc WHERE tc.COMMENT_BIZ_TYPE = ?1", nativeQuery = true)
    long getCommentCntByBizType(String commentBizType);

}
