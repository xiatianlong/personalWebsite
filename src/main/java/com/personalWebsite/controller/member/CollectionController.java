package com.personalWebsite.controller.member;

import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     *
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


}
