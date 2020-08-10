package com.alice.controller;

import com.alibaba.fastjson.JSON;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Set;

/**
 * apollo 整合框架
 *
 * @author liusc
 * 2020-7-14 22:47:22
 */
@RestController
@RequestMapping(path = "/configurations")
public class ApolloConfigurationController {
    public Log log = LogFactory.getLog(this.getClass());

    private Config config = ConfigService.getAppConfig();

    @RequestMapping(path = "/{key}")
    public String getConfigForKey(@PathVariable("key") String key) {
        Set<String> propertyNames = config.getPropertyNames();

        String path = "/user/local";
        File file = new File(path);
        file.mkdirs();
        file.mkdir();

        log.info(JSON.toJSONString(propertyNames));
        return ConfigService.getAppConfig().getProperty(key, "undefined");
    }

}
