package com.alice.controller;

import com.alibaba.fastjson.JSONObject;
import com.alice.entity.VisitorEntity;
import com.alice.service.IVisitorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
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

    private JSONObject result = new JSONObject();

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
        Collection<VisitorEntity> byAllVisitor = (ArrayList) visitorService.findByAllVisitor();
        result.put("visitorList", byAllVisitor);
        return result;
    }

    @RequestMapping("/findByCondition")
    public JSONObject findByCondition(Map<String,String> condition) {
        Collection<VisitorEntity> byCondition = (ArrayList) visitorService.findByCondition(condition);
        result.put("visitorList", byCondition);
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
