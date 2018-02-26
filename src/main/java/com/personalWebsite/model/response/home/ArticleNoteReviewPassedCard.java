package com.personalWebsite.model.response.home;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 审核通过的文章、笔记汇总卡片
 * Created by xiatianlong on 2018/2/23.
 */
public class ArticleNoteReviewPassedCard implements Serializable {
    private static final long serialVersionUID = 1175192983033187715L;

    /**
     * 类型（article, note）
     */
    private String type;

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
     * 封面图片文件
     */
    private String imgUrl;

    /**
     * 查看数量
     */
    private int viewsCnt;

    /**
     * 分类集合
     */
    private List<String> categoryList;

    /**
     * 分类集合(格式化)
     */
    private String fmtCategoryList;

    /**
     * 是否置顶
     */
    private boolean top;

    /**
     * 作者id
     */
    private String userId;

    /**
     * 作者名称
     */
    private String userName;

    /**
     * 作者头像
     */
    private String userHeadImg;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 文章创建时间(格式化)
     */
    private String fmtCreateTime;

    /**
     * 文章创建时间(格式化中文)
     */
    private String fmtCreateTimeCn;

    /**
     * 排序字段
     */
    private String orderKey;


    /**
     * 获取 类型（article, note）
     */
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
     * 获取 ID
     */
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
     * 获取 封面图片文件
     */
    public String getImgUrl() {
        return this.imgUrl;
    }

    /**
     * 设置 封面图片文件
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取 查看数量
     */
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
     * 获取 分类集合
     */
    public List<String> getCategoryList() {
        return this.categoryList;
    }

    /**
     * 设置 分类集合
     */
    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * 获取 分类集合(格式化)
     */
    public String getFmtCategoryList() {
        return this.fmtCategoryList;
    }

    /**
     * 设置 分类集合(格式化)
     */
    public void setFmtCategoryList(String fmtCategoryList) {
        this.fmtCategoryList = fmtCategoryList;
    }

    /**
     * 获取 是否置顶
     */
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
     * 获取 作者名称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 作者名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 创建时间
     */
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
     * 获取 文章创建时间(格式化)
     */
    public String getFmtCreateTime() {
        return this.fmtCreateTime;
    }

    /**
     * 设置 文章创建时间(格式化)
     */
    public void setFmtCreateTime(String fmtCreateTime) {
        this.fmtCreateTime = fmtCreateTime;
    }

    /**
     * 获取 文章创建时间(格式化中文)
     */
    public String getFmtCreateTimeCn() {
        return this.fmtCreateTimeCn;
    }

    /**
     * 设置 文章创建时间(格式化中文)
     */
    public void setFmtCreateTimeCn(String fmtCreateTimeCn) {
        this.fmtCreateTimeCn = fmtCreateTimeCn;
    }

    /**
     * 获取 作者头像
     */
    public String getUserHeadImg() {
        return this.userHeadImg;
    }

    /**
     * 设置 作者头像
     */
    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    /**
     * 获取 排序字段
     */
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
