package com.personalWebsite.entity.view;

import com.personalWebsite.entity.ArticleCategoryEntity;
import com.personalWebsite.entity.FileRelationEntity;
import com.personalWebsite.entity.NoteCategoryEntity;
import com.personalWebsite.entity.UserEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 审核通过的文章和笔记视图
 * Created by xiatianlong on 2018/2/21.
 */
@Entity(name = "t_view_article_note_review_passed")
public class ArticleNoteReviewPassedView implements Serializable {

    private static final long serialVersionUID = -8956229297075990638L;
    /**
     * ID
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String introduction;

    /**
     * 封面图片文件编号
     */
    private String imgNo;

    /**
     * 内容
     */
    private String content;

    /**
     * 查看数量
     */
    private int viewsCnt;

    /**
     * 是否置顶
     */
    private boolean top;

    /**
     * 作者id
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 类型（article, note）
     */
    private String type;

    /**
     * 排序字段
     */
    private String orderKey;


    /**
     * 文章所属类别
     */
    private List<ArticleCategoryEntity> articleCategoryEntities;

    /**
     * 笔记所属类别
     */
    private List<NoteCategoryEntity> noteCategoryEntities;

    /**
     * 文章作者信息
     */
    private UserEntity user;

    /**
     * 文章封面图片文件
     */
    private FileRelationEntity articleImgFile;

    /**
     * 获取 ID
     */
    @Id
    @Column(name = "ID", nullable = false)
    public String getId() {
        return this.id;
    }

    /**
     * 设置 ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 标题
     */
    @Column(name = "TITLE")
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 摘要
     */
    @Column(name = "INTRODUCTION")
    public String getIntroduction() {
        return this.introduction;
    }

    /**
     * 设置 摘要
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取 封面图片文件编号
     */
    @Column(name = "IMG")
    public String getImgNo() {
        return this.imgNo;
    }

    /**
     * 设置 封面图片文件编号
     */
    public void setImgNo(String imgNo) {
        this.imgNo = imgNo;
    }

    /**
     * 获取 内容
     */
    @Column(name = "CONTENT")
    public String getContent() {
        return this.content;
    }

    /**
     * 设置 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取 查看数量
     */
    @Column(name = "VIEWS_CNT")
    public int getViewsCnt() {
        return this.viewsCnt;
    }

    /**
     * 设置 查看数量
     */
    public void setViewsCnt(int viewsCnt) {
        this.viewsCnt = viewsCnt;
    }

    /**
     * 获取 是否置顶
     */
    @Column(name = "IS_TOP")
    public boolean isTop() {
        return this.top;
    }

    /**
     * 设置 是否置顶
     */
    public void setTop(boolean top) {
        this.top = top;
    }

    /**
     * 获取 作者id
     */
    @Column(name = "USER_ID")
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置 作者id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 创建时间
     */
    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 更新时间
     */
    @Column(name = "UPDATE_TIME")
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 类型（article, note）
     */
    @Column(name = "TYPE")
    public String getType() {
        return this.type;
    }

    /**
     * 设置 类型（article, note）
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * 获取 文章所属类别
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ARTICLE_ID", updatable = false, insertable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    public List<ArticleCategoryEntity> getArticleCategoryEntities() {
        return this.articleCategoryEntities;
    }

    /**
     * 设置 文章所属类别
     */
    public void setArticleCategoryEntities(List<ArticleCategoryEntity> articleCategoryEntities) {
        this.articleCategoryEntities = articleCategoryEntities;
    }

    /**
     * 获取 笔记所属类别
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "NOTE_ID", updatable = false, insertable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    public List<NoteCategoryEntity> getNoteCategoryEntities() {
        return this.noteCategoryEntities;
    }

    /**
     * 设置 笔记所属类别
     */
    public void setNoteCategoryEntities(List<NoteCategoryEntity> noteCategoryEntities) {
        this.noteCategoryEntities = noteCategoryEntities;
    }

    /**
     * 获取 文章作者信息
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", updatable = false, insertable = false)
    public UserEntity getUser() {
        return this.user;
    }

    /**
     * 设置 文章作者信息
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }


    /**
     * 获取 文章封面图片文件
     */
    @ManyToOne
    @JoinColumn(name = "IMG", referencedColumnName = "FILE_NO", updatable = false, insertable = false)
    public FileRelationEntity getArticleImgFile() {
        return this.articleImgFile;
    }

    /**
     * 设置 文章封面图片文件
     */
    public void setArticleImgFile(FileRelationEntity articleImgFile) {
        this.articleImgFile = articleImgFile;
    }


    /**
     * 获取 排序字段
     */
    @Column(name = "ORDER_KEY")
    public String getOrderKey() {
        return this.orderKey;
    }

    /**
     * 设置 排序字段
     */
    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }
}
