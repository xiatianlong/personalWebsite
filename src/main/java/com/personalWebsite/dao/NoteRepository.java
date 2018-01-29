package com.personalWebsite.dao;

import com.personalWebsite.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 笔记 Repository
 * Created by xiatianlong on 2018/1/29.
 */
public interface NoteRepository extends JpaRepository<NoteEntity, String> {

    /**
     * 根据id查询笔记
     *
     * @param noteId 笔记id
     * @return 笔记
     */
    @Query(value = "SELECT * FROM t_note note WHERE note.NOTE_ID = ?1 AND note.IS_DELETE = 0", nativeQuery = true)
    NoteEntity findByNoteId(String noteId);
}
