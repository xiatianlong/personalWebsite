package com.personalWebsite.entity;

import com.personalWebsite.entity.id.CollectionId;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Created by xiatianlong on 2018/2/26.
 */
@Entity(name = "t_collection")
@IdClass(CollectionId.class)
public class CollectionEntity extends BaseEntity {
    private static final long serialVersionUID = -1114439580499811172L;

    /**
     * 业务id
     */
    private String bizId;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 用户id
     */
    private String UserId;

    /**
     * 是否删除
     */
    private boolean deleted;

    /**
     * 收藏用户
     */
    private UserEntity userEntity;

    /**
     * 文章
     */
    private ArticleEntity articleEntity;

    /**
     * 笔记
     */
    private NoteEntity noteEntity;

    /**
     * 获取 业务id
     */
    @Id
    @Column(name = "BIZ_ID", nullable = false, length = 50)
    public String getBizId() {
        return this.bizId;
    }

    /**
     * 设置 业务id
     */
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    /**
     * 获取 业务类型
     */
    @Id
    @Column(name = "BIZ_TYPE", nullable = false, length = 50)
    public String getBizType() {
        return this.bizType;
    }

    /**
     * 设置 业务类型
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * 获取 用户id
     */
    @Id
    @Column(name = "USER_ID", nullable = false, length = 50)
    public String getUserId() {
        return this.UserId;
    }

    /**
     * 设置 用户id
     */
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    /**
     * 获取 是否删除
     */
    @Column(name = "IS_DELETE", nullable = false)
    public boolean isDeleted() {
        return this.deleted;
    }

    /**
     * 设置 是否删除
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    /**
     * 获取 收藏用户
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", updatable = false, insertable = false)
    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    /**
     * 设置 收藏用户
     */
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }


    /**
     * 获取 文章
     */
    @ManyToOne
    @JoinColumn(name = "BIZ_ID", referencedColumnName = "ARTICLE_ID", updatable = false, insertable = false)
    @Where(clause = " BIZ_TYPE = '001001'")
    @NotFound(action = NotFoundAction.IGNORE)
    public ArticleEntity getArticleEntity() {
        return this.articleEntity;
    }

    /**
     * 设置 文章
     */
    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    /**
     * 获取 笔记
     */
    @ManyToOne
    @JoinColumn(name = "BIZ_ID", referencedColumnName = "NOTE_ID", updatable = false, insertable = false)
    @Where(clause = " BIZ_TYPE = '001002'")
    @NotFound(action = NotFoundAction.IGNORE)
    public NoteEntity getNoteEntity() {
        return this.noteEntity;
    }

    /**
     * 设置 笔记
     */
    public void setNoteEntity(NoteEntity noteEntity) {
        this.noteEntity = noteEntity;
    }
}
