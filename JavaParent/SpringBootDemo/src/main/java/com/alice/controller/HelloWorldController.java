package com.alice.controller;

import cn.hutool.core.lang.UUID;
import com.alice.service.AsyncService;
import com.alice.service.RedisService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * index
 *
 * @author liusc
 */
@RestController
public class HelloWorldController {
    public static Log log = LogFactory.getLog(HelloWorldController.class);
    @Autowired
    private AsyncService asyncService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/")
    public String index() {
        log.info("com.alice.controller.HelloWorldController.index");
        return "helloWorld docker  SpringBoot " + new Date().toString();
    }

    //    @Async("asyncServiceExecutor")
    @RequestMapping("/info")
    public String info() throws InterruptedException, ExecutionException {
        log.info("com.alice.controller.HelloWorldController.info  threadName => " + Thread.currentThread().getName());

        CompletableFuture<String> createOrder = asyncService.doSomething1("create order");
        CompletableFuture<String> reduceAccount = asyncService.doSomething2("reduce account");
        CompletableFuture<String> saveLog = asyncService.doSomething3("save log");
        // 等待所有任务都执行完
        CompletableFuture.allOf(createOrder, reduceAccount, saveLog).join();

        // 获取每个任务的返回结果
        String result = createOrder.get() + reduceAccount.get() + saveLog.get();


        return result;
    }

}
