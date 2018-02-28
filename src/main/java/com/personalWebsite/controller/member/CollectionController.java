package com.personalWebsite.controller.member;

import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.entity.CollectionEntity;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 收藏Controller.
 * Created by xiatianlong on 2018/2/26.
 */
@Controller
@RequestMapping("/member/collection")
public class CollectionController extends BaseController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 添加收藏
     * @param bizType 业务类型
     * @param bizId 业务id
     * @return result
     */
    @PostMapping("/{bizType}/{bizId}")
    @ResponseBody
    public AsynchronousResult collection(@PathVariable("bizType") String bizType, @PathVariable("bizId") String bizId) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        collectionService.doCollection(bizType, bizId);
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 我的收藏列表
     *
     * @param model model
     * @return list
     */
    @GetMapping("/list")
    public String myCollectionList(Model model) {

        List<CollectionEntity> collectionEntityList = collectionService.getCollectionsByUser(getLoinUser().getUserId());
        model.addAttribute("collectionMap", collectionService.getCollectionGroupByBizType(collectionEntityList));

        return "personalCenter/collection/myCollectionList";
    }

    /**
     * 删除收藏
     *
     * @param bizType 业务类型
     * @param bizId   业务id
     * @return result
     * @throws Exception e
     */
    @PostMapping("/remove/{bizType}/{bizId}")
    @ResponseBody
    public AsynchronousResult removeCollection(@PathVariable("bizType") String bizType, @PathVariable("bizId") String bizId) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        collectionService.removeCollection(bizType, bizId);
        result.setResult(Constant.SUCCESS);
        return result;
    }

}
