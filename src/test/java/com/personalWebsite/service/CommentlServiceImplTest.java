package com.personalWebsite.service;

import com.personalWebsite.dao.CommentRepository;
import com.personalWebsite.entity.CommentEntity;
import com.personalWebsite.model.request.comment.CommentPageForm;
import com.personalWebsite.vo.CommentInfo;
import com.personalWebsite.vo.PageVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by xiatianlong on 2018/1/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:spring-mvc-web.xml",
        "classpath:spring-mvc-data.xml",
        "classpath:spring-mvc-biz.xml"})
public class CommentlServiceImplTest {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;


    @Test
    public void testFindOneComment() throws Exception {

        CommentEntity commentEntity = commentRepository.findOne("1801091613291000010");
        Assert.assertNotNull(commentEntity);
    }

    @Test
    public void testGetCommentListByPage() {

        PageVO<CommentEntity> commentEntityPage = commentService.getCommentListByPage(new CommentPageForm());
        if (commentEntityPage != null) {
            System.out.println("totalCnt:" + commentEntityPage.getTotalCnt());
            System.out.println("totalPages:" + commentEntityPage.getTotalPages());
            System.out.println("pageNo:" + commentEntityPage.getPageNo());
            System.out.println("pageSize:" + commentEntityPage.getPageSize());
            List<CommentEntity> commentEntities = commentEntityPage.getDataList();
            List<CommentInfo> commentInfos = commentService.getCommentInfo(commentEntities);
            if (commentInfos != null && !commentInfos.isEmpty()) {
                for (CommentInfo entity : commentInfos) {
                    System.out.println(entity.getCommentId() + "\t" + entity.getCommentContent());
                }
            }
        }

    }

    ;

}
