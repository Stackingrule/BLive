package com.nowcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Title: BLiveApplication
 * @Package: com.nowcode
 * @description: 启动类
 * @author: Stackingrule
 * @created: 2022/02/23 23:46
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
@SpringBootApplication
public class BLiveApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(BLiveApplication.class, args);
    }
}
