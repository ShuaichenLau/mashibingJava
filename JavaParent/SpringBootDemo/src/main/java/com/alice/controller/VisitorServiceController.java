package com.alice.controller;

import com.alibaba.fastjson.JSONObject;
import com.alice.entity.VisitorEntity;
import com.alice.service.IVisitorService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 访客登记controller
 *
 * @author liusc
 * 2020-7-14 11:39:12
 */
@RestController
public class VisitorServiceController {

    public Log log = LogFactory.getLog(this.getClass());

    private static JSONObject result = new JSONObject();

    @Autowired
    private IVisitorService visitorService;

    @RequestMapping("/addVisitor")
    public JSONObject visitor() {
        VisitorEntity visitorEntity = visitorService.addVisitorEntity();
        result.put("result", visitorEntity);
        return result;
    }

    @RequestMapping("/findByAllVisitor")
    public JSONObject findByAllVisitor() {
        Collection<VisitorEntity> byAllVisitor = visitorService.findByAllVisitor();
        result.put("visitorList", byAllVisitor);
        result.put("visitorCount", byAllVisitor.size());
        result.put("size", byAllVisitor.size());
        return result;
    }

    @RequestMapping("/findByCondition")
    public JSONObject findByCondition(VisitorEntity visitorCondition) {

        Collection<VisitorEntity> byCondition = Lists.newArrayList();

        try {
            byCondition = visitorService.findByCondition(visitorCondition);
            result.put("visitorList", byCondition);
            result.put("msg", "查询成功");
            result.put("Count", byCondition.size());
        } catch (Exception e) {
            result.put("visitorList", byCondition);
            result.put("msg", "查询失败");
            result.put("Count", byCondition.size());
        }

        return result;
    }


    @RequestMapping("/deleteVisitor")
    public JSONObject delete(int id) {
        boolean flag = visitorService.deleteVisitor(id);
        if (flag == true) result.put("msg", "删除成功");
        else result.put("msg", "删除失败");
        return result;
    }

}
