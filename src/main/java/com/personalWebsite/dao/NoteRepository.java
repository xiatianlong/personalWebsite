package com.personalWebsite.dao;

import com.personalWebsite.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 笔记 Repository
 * Created by xiatianlong on 2018/1/29.
 */
public interface NoteRepository extends JpaRepository<NoteEntity, String>, JpaSpecificationExecutor<NoteEntity> {

    /**
     * 根据id查询笔记
     *
     * @param noteId 笔记id
     * @return 笔记
     */
    @Query(value = "SELECT * FROM t_note note WHERE note.NOTE_ID = ?1 AND note.IS_DELETE = 0", nativeQuery = true)
    NoteEntity findByNoteId(String noteId);

    /**
     * 查询我的笔记分类
     *
     * @return list
     */
    @Query(value = "SELECT category.NOTE_CATEGORY\n" +
            "FROM t_note_category category LEFT JOIN t_note note\n" +
            "    ON category.NOTE_ID = note.NOTE_ID AND note.IS_DELETE = 0\n" +
            "WHERE note.USER_ID = ?1\n" +
            "GROUP BY category.NOTE_CATEGORY", nativeQuery = true)
    List<String> getMyNoteCategory(String userId);

    /**
     * 查询审核通过的笔记分类
     *
     * @return list
     */
    @Query(value = "SELECT category.NOTE_CATEGORY\n" +
            "FROM t_note_category category LEFT JOIN t_note note\n" +
            "    ON category.NOTE_ID = note.NOTE_ID AND note.IS_DELETE = 0 AND note.IS_DELETE = '002003'\n" +
            "GROUP BY category.NOTE_CATEGORY", nativeQuery = true)
    List<String> getViewNoteCategory();

    /**
     * 获取审核通过笔记数量
     *
     * @return int
     */
    @Query(value = "SELECT count(note.NOTE_ID)\n" +
            "FROM t_note note\n" +
            "WHERE note.IS_DELETE = 0 AND note.NOTE_STATUS = '003003'", nativeQuery = true)
    int getReviewPassedNoteCnt();
}
