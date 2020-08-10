package com.alice.controller;

import cn.hutool.core.lang.UUID;
import com.alice.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {


    @Autowired
    private RedisService redisService;

    public void addRedisData(int i) {
        redisService.set("" + i, UUID.randomUUID().toString().replaceAll("-", ""));
    }

    public void getRedisData(int i) {
        System.out.println(redisService.getKey("" + i));
    }

    @RequestMapping("/redisTest")
    public void redisTest() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            addRedisData(i);
//            getRedisData(i);
        }
        System.out.println(System.currentTimeMillis() - l + " ms");
    }
}
