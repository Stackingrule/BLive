package com.nowcode.blive.service;

import com.nowcode.blive.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: DemoService
 * @Package: com.nowcode.blive.service
 * @description:
 * @author: Stackingrule
 * @created: 2022/02/24 09:55
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    public Long query(Long id) {
        return demoDao.query(id);
    }
}
