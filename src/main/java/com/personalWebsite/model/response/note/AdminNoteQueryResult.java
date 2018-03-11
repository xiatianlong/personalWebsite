package com.personalWebsite.model.response.note;

import com.personalWebsite.model.response.AsynchronousResult;

import java.util.List;

/**
 * 后台笔记查询结果
 * Created by xiatianlong on 2018/1/31.
 */
public class AdminNoteQueryResult extends AsynchronousResult {
    private static final long serialVersionUID = -6773848177058011703L;

    /**
     * 笔记卡片集合
     */
    private List<NoteInfo> noteInfos;

    /**
     * 数据数量
     */
    private long dataCount;

    /**
     * 获取 数据数量
     */
    public long getDataCount() {
        return this.dataCount;
    }

    /**
     * 设置 数据数量
     */
    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    /**
     * 获取 笔记卡片集合
     */
    public List<NoteInfo> getNoteInfos() {
        return this.noteInfos;
    }

    /**
     * 设置 笔记卡片集合
     */
    public void setNoteInfos(List<NoteInfo> noteInfos) {
        this.noteInfos = noteInfos;
    }
}
