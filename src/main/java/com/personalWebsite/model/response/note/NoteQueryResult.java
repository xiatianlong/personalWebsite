package com.personalWebsite.model.response.note;

import com.personalWebsite.model.response.AsynchronousResult;

import java.util.List;

/**
 * 笔记查询结果
 * Created by xiatianlong on 2018/1/31.
 */
public class NoteQueryResult extends AsynchronousResult {

    private static final long serialVersionUID = -5809811234892771583L;
    /**
     * 笔记卡片集合
     */
    private List<NoteCard> noteCardList;

    /**
     * 是否显示加载更多
     */
    private boolean hasMore;

    /**
     * 获取 笔记卡片集合
     */
    public List<NoteCard> getNoteCardList() {
        return this.noteCardList;
    }

    /**
     * 设置 笔记卡片集合
     */
    public void setNoteCardList(List<NoteCard> noteCardList) {
        this.noteCardList = noteCardList;
    }

    /**
     * 获取 是否显示加载更多
     */
    public boolean isHasMore() {
        return this.hasMore;
    }

    /**
     * 设置 是否显示加载更多
     */
    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
