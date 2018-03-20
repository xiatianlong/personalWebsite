package com.personalWebsite.service;

import com.personalWebsite.common.enums.BizType;
import com.personalWebsite.common.enums.NoteStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.dao.AuditRepository;
import com.personalWebsite.dao.EmailRecordRepository;
import com.personalWebsite.dao.NoteCategoryRepository;
import com.personalWebsite.dao.NoteRepository;
import com.personalWebsite.dictionary.DictionaryCache;
import com.personalWebsite.entity.*;
import com.personalWebsite.model.request.AuditForm;
import com.personalWebsite.model.request.note.AdminNotePageForm;
import com.personalWebsite.model.request.note.NotePageForm;
import com.personalWebsite.model.request.note.SaveOrUpdateForm;
import com.personalWebsite.model.response.note.AdminNoteQueryResult;
import com.personalWebsite.model.response.note.NoteCard;
import com.personalWebsite.model.response.note.NoteInfo;
import com.personalWebsite.utils.DateUtil;
import com.personalWebsite.utils.IdUtil;
import com.personalWebsite.utils.PropertiesUtil;
import com.personalWebsite.utils.UUIDUtil;
import com.personalWebsite.vo.UserInfo;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.*;

/**
 * 笔记服务类.
 * Created by xiatianlong on 2018/1/29.
 */
@Service
@Transactional(readOnly = true)
public class NoteServiceImpl extends BaseServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private AuditRepository auditRepository;
    @Autowired
    private NoteCategoryRepository noteCategoryRepository;
    @Autowired
    private EmailRecordRepository emailRecordRepository;

    /**
     * 根据笔记id获取笔记
     *
     * @param noteId 笔记id
     * @return 笔记
     */
    @Override
    public NoteEntity getNoteById(String noteId) {
        if (StringUtils.isEmpty(noteId)) {
            return null;
        }
        return noteRepository.findByNoteId(noteId);
    }

    @Override
    public List<NoteCard> getMyNoteList(final NotePageForm notePageForm) {

        // 创建时间倒序（id）
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "noteId");
        Pageable pageable = new PageRequest(notePageForm.getPageNo() - 1, notePageForm.getPageSize(), new Sort(order));
        Specification<NoteEntity> specification = new Specification<NoteEntity>() {
            @Override
            public Predicate toPredicate(Root<NoteEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicateList = new ArrayList<>();

                predicateList.add(cb.equal(root.get("userId"), getLoinUser().getUserId()));
                predicateList.add(cb.equal(root.get("deleted"), false));

                // 查询条件-状态
                if (notePageForm.getNoteStatus() != null && notePageForm.getNoteStatus().length > 0) {
                    CriteriaBuilder.In<String> in = cb.in(root.<String>get("noteStatus"));
                    for (String str : notePageForm.getNoteStatus()) {
                        in.value(str);
                    }
                    predicateList.add(in);
                }

                // 查询条件-类别
                if (notePageForm.getNoteCategory() != null && notePageForm.getNoteCategory().length > 0) {
                    Join<NoteEntity, NoteCategoryEntity> categoryJoin = root.join("categoryEntityList", JoinType.LEFT);
                    CriteriaBuilder.In<String> in = cb.in(categoryJoin.<String>get("noteCategory"));
                    for (String str : notePageForm.getNoteCategory()) {
                        in.value(str);
                    }
                    predicateList.add(in);
                }

                // 排序条件
                if (!StringUtils.isEmpty(notePageForm.getNoteId())) {
                    predicateList.add(cb.lessThan(root.<String>get("noteId"), notePageForm.getNoteId()));
                }

                // 去重处理
                query.distinct(true);

                Predicate[] pre = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(pre));
            }
        };

        return buildNoteCard(noteRepository.findAll(specification, pageable).getContent());
    }

    /**
     * 获取笔记类别
     *
     * @return 类别集合
     */
    @Override
    public List<String> getNoteCategory() {
        return noteRepository.getMyNoteCategory(getLoinUser().getUserId());
    }

    /**
     * 获取可见的笔记类别
     *
     * @return 类别集合
     */
    @Override
    public List<String> getViewNoteCategory() {
        return noteRepository.getViewNoteCategory();
    }

    /**
     * 获取全部笔记类别
     *
     * @return 类别集合
     */
    @Override
    public List<String> getAllNoteCategory() {
        return noteRepository.getAllNoteCategory();
    }


    /**
     * 构建笔记卡片信息
     *
     * @param noteEntities 笔记实体对象集合
     * @return 卡片集合
     */
    private List<NoteCard> buildNoteCard(List<NoteEntity> noteEntities) {

        if (noteEntities != null && !noteEntities.isEmpty()) {
            List<NoteCard> noteCards = new ArrayList<>();
            for (NoteEntity noteEntity : noteEntities) {
                NoteCard noteCard = new NoteCard();
                // 笔记id
                noteCard.setNoteId(noteEntity.getNoteId());
                // 笔记标题
                noteCard.setNoteTitle(noteEntity.getNoteTitle());
                // 创建者id
                noteCard.setUserId(noteEntity.getUser().getUserId());
                // 创建者名称
                noteCard.setUserName(noteEntity.getUser().getUserName());
                // 访问量
                noteCard.setNoteViewsCnt(noteEntity.getNoteViewCnt());
                // 是否置顶
                noteCard.setTop(noteEntity.isTop());
                // 笔记分类
                List<NoteCategoryEntity> categoryEntities = noteEntity.getCategoryEntityList();
                if (categoryEntities != null && !categoryEntities.isEmpty()) {
                    List<String> strArr = new ArrayList<>();
                    StringBuilder fmtStr = new StringBuilder();
                    for (int i = 0; i < categoryEntities.size(); i++) {
                        strArr.add(categoryEntities.get(i).getNoteCategory());
                        fmtStr.append(categoryEntities.get(i).getNoteCategory());
                        if (categoryEntities.size() != (i + 1)) {
                            fmtStr.append(",");
                        }
                    }
                    noteCard.setCategoryList(strArr);
                    noteCard.setFmtCategoryList(fmtStr.toString());
                }
                if (StringUtils.isEmpty(noteCard.getFmtCategoryList())) {
                    noteCard.setFmtCategoryList("--");
                }
                // 笔记状态
                noteCard.setNoteStatus(noteEntity.getNoteStatus());
                // 笔记创建时间
                noteCard.setCreateTime(noteEntity.getCreateTime());
                // 笔记创建时间(格式化)
                noteCard.setFmtCreateTime(DateUtil.defaultFormat(noteEntity.getCreateTime()));
                // 笔记创建时间(中文格式化)
                noteCard.setFmtCreateTimeCN(DateUtil.getStrDate(noteEntity.getCreateTime()));

                noteCards.add(noteCard);
            }
            return noteCards;
        } else {
            return null;
        }
    }
    
    
    /**
     * 创建笔记
     *
     * @param form form
     */
    @Override
    @Transactional
    public void saveNote(SaveOrUpdateForm form) {
        NoteEntity noteEntity = new NoteEntity();

        UserInfo userInfo = getLoinUser();
        Date now = new Date();
        // 笔记id
        noteEntity.setNoteId(IdUtil.createId(userInfo.getUserId()));
        // 笔记标题
        noteEntity.setNoteTitle(form.getNoteTitle());
        // 笔记状态
        noteEntity.setNoteStatus(form.getNoteStatus());
        // 笔记内容
        noteEntity.setNoteContent(form.getNoteContent());
        // 访问量
        noteEntity.setNoteViewCnt(0);
        // 是否删除
        noteEntity.setDeleted(false);
        // 作者id
        noteEntity.setUserId(userInfo.getUserId());

        noteEntity.setCreateTime(now);
        noteEntity.setUpdateTime(now);
        noteEntity.setCreateUser(userInfo.getUserId());
        noteEntity.setUpdateUser(userInfo.getUserId());

        noteRepository.save(noteEntity);
    }

    /**
     * 更新笔记
     *
     * @param form       form
     * @param noteEntity 笔记对象
     */
    @Transactional
    @Override
    public void updateNote(SaveOrUpdateForm form, NoteEntity noteEntity) {

        // 笔记标题
        noteEntity.setNoteTitle(form.getNoteTitle());
        // 笔记状态
        noteEntity.setNoteStatus(form.getNoteStatus());
        // 笔记内容
        noteEntity.setNoteContent(form.getNoteContent());

        noteEntity.setUpdateTime(new Date());
        noteEntity.setUpdateUser(getLoinUser().getUserId());

        noteRepository.saveAndFlush(noteEntity);
    }

    /**
     * 删除笔记对象
     *
     * @param noteEntity 笔记对象
     */
    @Override
    public void removeNote(NoteEntity noteEntity) throws Exception {
        if (noteEntity != null) {
            noteEntity.setDeleted(true);
            noteEntity.setUpdateTime(new Date());
            noteEntity.setUpdateUser(getLoinUser().getUserId());
            noteRepository.saveAndFlush(noteEntity);
        } else {
            throw new ApplicationException(getMessage("note.null"));
        }
    }

    /**
     * 构建笔记信息
     *
     * @param noteEntity 笔记实体对象
     * @return info
     */
    @Override
    public NoteInfo buildNoteInfo(NoteEntity noteEntity) {
        if (noteEntity == null) {
            return null;
        }
        NoteInfo noteInfo = new NoteInfo();
        // 笔记id
        noteInfo.setNoteId(noteEntity.getNoteId());
        // 笔记标题
        noteInfo.setNoteTitle(noteEntity.getNoteTitle());
        // 笔记状态
        noteInfo.setNoteStatus(noteEntity.getNoteStatus());
        noteInfo.setNoteStatusName(DictionaryCache.getName(noteEntity.getNoteStatus()));
        // 笔记内容
        noteInfo.setNoteContent(noteEntity.getNoteContent());
        // 笔记访问量
        noteInfo.setNoteViewCnt(noteEntity.getNoteViewCnt());
        // 是否置顶
        noteInfo.setTop(noteEntity.isTop());
        // 作者信息
        UserEntity userEntity = noteEntity.getUser();
        noteInfo.setUserId(userEntity.getUserId());
        noteInfo.setUserName(userEntity.getUserName());
        // 笔记分类
        // 笔记分类
        List<NoteCategoryEntity> categoryEntities = noteEntity.getCategoryEntityList();
        if (categoryEntities != null && !categoryEntities.isEmpty()) {
            List<String> strArr = new ArrayList<>();
            StringBuilder fmtStr = new StringBuilder();
            for (int i = 0; i < categoryEntities.size(); i++) {
                strArr.add(categoryEntities.get(i).getNoteCategory());
                fmtStr.append(categoryEntities.get(i).getNoteCategory());
                if (categoryEntities.size() != (i + 1)) {
                    fmtStr.append(",");
                }
            }
            noteInfo.setCategoryList(strArr);
            noteInfo.setFmtCategoryList(fmtStr.toString());
        }
        if (StringUtils.isEmpty(noteInfo.getFmtCategoryList())) {
            noteInfo.setFmtCategoryList("--");
        }
        // 创建时间
        noteInfo.setCreateTime(noteEntity.getCreateTime());
        noteInfo.setFmtCreateTime(DateUtil.defaultFormat(noteEntity.getCreateTime()));
        // 更新时间
        noteInfo.setUpdateTime(noteEntity.getUpdateTime());
        noteInfo.setFmtUpdateTime(DateUtil.defaultFormat(noteEntity.getUpdateTime()));
        return noteInfo;
    }

    /**
     * 获取可查看的笔记列表
     *
     * @param notePageForm form
     * @return 笔记列表
     */
    @Override
    public List<NoteCard> getViewNoteList(final NotePageForm notePageForm) {
        // 创建时间倒序(id)
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "noteId");
        Pageable pageable = new PageRequest(notePageForm.getPageNo() - 1, notePageForm.getPageSize(), new Sort(order));
        Specification<NoteEntity> specification = new Specification<NoteEntity>() {
            @Override
            public Predicate toPredicate(Root<NoteEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicateList = new ArrayList<>();
                // 审核通过的
                predicateList.add(cb.equal(root.get("noteStatus"), NoteStatus.REVIEW_PASSED.getCode()));
                predicateList.add(cb.equal(root.get("deleted"), false));

                // 查询条件-类别
                if (notePageForm.getNoteCategory() != null && notePageForm.getNoteCategory().length > 0) {
                    Join<NoteEntity, NoteCategoryEntity> categoryJoin = root.join("categoryEntityList", JoinType.LEFT);
                    CriteriaBuilder.In<String> in = cb.in(categoryJoin.<String>get("noteCategory"));
                    for (String str : notePageForm.getNoteCategory()) {
                        in.value(str);
                    }
                    predicateList.add(in);
                }

                // 排序条件
                if (!StringUtils.isEmpty(notePageForm.getNoteId())) {
                    predicateList.add(cb.lessThan(root.<String>get("noteId"), notePageForm.getNoteId()));
                }

                // 去重处理
                query.distinct(true);

                Predicate[] pre = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(pre));
            }
        };

        return buildNoteCard(noteRepository.findAll(specification, pageable).getContent());
    }

    /**
     * 获取全部笔记列表
     *
     * @param adminNotePageForm form
     * @return 笔记列表
     */
    @Override
    public AdminNoteQueryResult getAllNoteList(final AdminNotePageForm adminNotePageForm) {
        AdminNoteQueryResult result = new AdminNoteQueryResult();

        // 创建时间倒序(id)
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "noteId");
        Pageable pageable = new PageRequest(adminNotePageForm.getPageNo() - 1, adminNotePageForm.getPageSize(), new Sort(order));
        Specification<NoteEntity> specification = new Specification<NoteEntity>() {
            @Override
            public Predicate toPredicate(Root<NoteEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicateList = new ArrayList<>();
                // 是否删除的
                if (adminNotePageForm.getDeleted() != null) {
                    predicateList.add(cb.equal(root.get("deleted"), adminNotePageForm.getDeleted() == 1));
                }

                // 文章id
                if (adminNotePageForm.getNoteId() != null) {
                    predicateList.add(cb.like(root.<String>get("noteId"), "%" + adminNotePageForm.getNoteId() + "%"));
                }

                // 关键字（ID、title）
                if (adminNotePageForm.getKeyword() != null) {
                    predicateList.add(
                            cb.or(
                                    cb.like(root.<String>get("noteId"), "%" + adminNotePageForm.getKeyword() + "%"),
                                    cb.like(root.<String>get("noteTitle"), "%" + adminNotePageForm.getKeyword() + "%")
                            )
                    );
                }

                // 查询条件-类别
                if (adminNotePageForm.getNoteCategory() != null && adminNotePageForm.getNoteCategory().length > 0) {
                    Join<NoteEntity, NoteCategoryEntity> categoryJoin = root.join("categoryEntityList", JoinType.LEFT);
                    CriteriaBuilder.In<String> in = cb.in(categoryJoin.<String>get("noteCategory"));
                    for (String str : adminNotePageForm.getNoteCategory()) {
                        in.value(str);
                    }
                    predicateList.add(in);
                }

                // 查询条件-状态
                if (adminNotePageForm.getNoteStatus() != null && adminNotePageForm.getNoteStatus().length > 0) {
                    CriteriaBuilder.In<String> in = cb.in(root.<String>get("noteStatus"));
                    for (String str : adminNotePageForm.getNoteStatus()) {
                        in.value(str);
                    }
                    predicateList.add(in);
                }

                // 去重处理
                query.distinct(true);

                Predicate[] pre = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(pre));
            }
        };
        Page<NoteEntity> page = noteRepository.findAll(specification, pageable);
        List<NoteEntity> noteEntities = page.getContent();
        if (noteEntities != null && !noteEntities.isEmpty()) {
            List<NoteInfo> noteInfos = new ArrayList<>();
            for (NoteEntity noteEntity : noteEntities) {
                noteInfos.add(buildNoteInfo(noteEntity));
            }
            result.setNoteInfos(noteInfos);
            result.setDataCount(page.getTotalElements());
        }
        return result;
    }

    /**
     * 增加笔记访问量
     *
     * @param noteId 笔记id
     */
    @Transactional
    @Override
    public void addNoteViewCnt(String noteId) throws Exception {
        NoteEntity noteEntity = getNoteById(noteId);
        if (noteEntity != null) {
            noteEntity.setNoteViewCnt(noteEntity.getNoteViewCnt() + 1);
            noteRepository.saveAndFlush(noteEntity);
        }
    }

    /**
     * 笔记审核
     *
     * @param noteId 笔记id
     * @param form   请求表单
     * @throws Exception e
     */
    @Override
    public void auditNote(String noteId, AuditForm form) throws Exception {
        // 校验状态
        if (!NoteStatus.UNDER_REVIEW.getCode().equals(form.getStatus())
                && !NoteStatus.REVIEW_PASSED.getCode().equals(form.getStatus())
                && !NoteStatus.REVIEW_NOT_PASSED.getCode().equals(form.getStatus())) {
            throw new ApplicationException(getMessage("audit.status.error"));
        }
        // 检验备注
        if (StringUtils.isEmpty(form.getAuditMemo()) || form.getAuditMemo().length() > 150) {
            throw new ApplicationException(getMessage("audit.memo.length"));
        }

        NoteEntity noteEntity = getNoteById(noteId);
        if (noteEntity == null) {
            throw new ApplicationException(getMessage("note.not.exist"));
        }
        // 检验分类
        if (form.getCategory() == null || form.getCategory().length <= 0 || form.getCategory().length > 5) {
            throw new ApplicationException(getMessage("audit.category.null"));
        }

        List<NoteCategoryEntity> categoryEntities = noteEntity.getCategoryEntityList();
        // 删除原分类
        if (categoryEntities != null && !categoryEntities.isEmpty()) {
            noteCategoryRepository.delete(categoryEntities);
        }

        Date now = new Date();

        // 如果文章原状态是审核中，则向作者发送已提醒审核
        if (NoteStatus.UNDER_REVIEW.getCode().equals(noteEntity.getNoteStatus())
                && !StringUtils.isEmpty(noteEntity.getUser().getUserEmail())) {
            // 给管理员发送错误邮件
            EmailRecordEntity emailRecordEntity = new EmailRecordEntity();
            emailRecordEntity.setEmailCode(UUIDUtil.getUUID());
            emailRecordEntity.setEmailTo(noteEntity.getUser().getUserEmail());
            emailRecordEntity.setCreateTime(now);
            emailRecordEntity.setUpdateTime(now);
            emailRecordEntity.setCreateUser(getLoinUser().getUserId());
            emailRecordEntity.setUpdateUser(getLoinUser().getUserId());
            Template template = mailTemplate.getConfiguration().getTemplate("auditTemplate.ftl");
            Map<String, Object> map = new HashMap<>();
            map.put("userName", noteEntity.getUser().getUserName());
            map.put("bizType", DictionaryCache.getName(BizType.NOTE.getCode()));
            map.put("title", noteEntity.getNoteTitle());
            map.put("status", DictionaryCache.getName(form.getStatus()));
            map.put("url", PropertiesUtil.getProperty("domain") + "/member/note/" + noteEntity.getNoteId());
            map.put("time", DateUtil.defaultFormat(now));
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
            emailRecordEntity.setEmailContent(content);
            emailRecordRepository.save(emailRecordEntity);
        }

        // 添加审核记录
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setBizId(noteId);
        auditEntity.setBizType(BizType.NOTE.getCode());
        auditEntity.setAuditMemo(form.getAuditMemo());
        auditEntity.setAuditContent(getMessage("audit.status.change",
                new Object[]{DictionaryCache.getName(noteEntity.getNoteStatus()),
                        DictionaryCache.getName(form.getStatus())}));
        auditEntity.setCreateTime(now);
        auditEntity.setUpdateTime(now);
        auditEntity.setCreateUser(getLoinUser().getUserId());
        auditEntity.setUpdateUser(getLoinUser().getUserId());
        auditRepository.save(auditEntity);

        // 更新文章状态
        noteEntity.setNoteStatus(form.getStatus());
        noteEntity.setUpdateTime(now);
        noteEntity.setUpdateUser(getLoinUser().getUserId());
        noteRepository.saveAndFlush(noteEntity);

        // 添加新分类
        Set<String> categorys = new HashSet<>(Arrays.asList(form.getCategory()));
        for (String str : categorys) {
            NoteCategoryEntity noteCategoryEntity = new NoteCategoryEntity();
            noteCategoryEntity.setNoteId(noteId);
            noteCategoryEntity.setNoteCategory(str);
            noteCategoryEntity.setCreateTime(now);
            noteCategoryEntity.setUpdateTime(now);
            noteCategoryEntity.setCreateUser(getLoinUser().getUserId());
            noteCategoryEntity.setUpdateUser(getLoinUser().getUserId());
            noteCategoryRepository.save(noteCategoryEntity);
        }
    }

    /**
     * 获取文章总数
     *
     * @return 文章总数
     */
    @Override
    public int getNoteCnt() {
        return noteRepository.getAllNoteCnt();
    }

    /**
     * 获取某个状态下的文章数量
     *
     * @param status 状态
     * @return 文章数
     */
    @Override
    public int getNoteCntByStatus(String status) {
        return noteRepository.getNoteCntByStatus(status);
    }

}
