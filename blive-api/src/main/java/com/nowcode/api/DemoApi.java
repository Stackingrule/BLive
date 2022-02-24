package com.nowcode.api;

import com.nowcode.blive.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: DemoApi
 * @Package: com.nowcode.api
 * @description:
 * @author: Stackingrule
 * @created: 2022/02/24 09:57
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
@RestController
public class DemoApi {

    @Autowired
    private DemoService demoService;

    @GetMapping("/query")
    public Long query(Long id) {
        return demoService.query(id);
    }
}
