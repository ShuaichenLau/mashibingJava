package com;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liusc
 * 2020-7-11 22:52:48
 *
 *
 * 练习题
 * 生产者生产数据 随机时间生产数据到数据库
 *
 * 消费者环境需要及时消费数据 并且更改状态  需要完成削峰
 *
 * eg 营业厅场景  当进来一个客户时候  需要完成登记 落库 并且及时完成客户分发到员工接待
 *
 */
@SpringBootApplication
@EnableApolloConfig
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class,args);
    }
}
