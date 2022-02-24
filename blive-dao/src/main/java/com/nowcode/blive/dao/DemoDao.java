package com.nowcode.blive.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: DemoDao
 * @Package: com.nowcode.blive.dao
 * @description:
 * @author: Stackingrule
 * @created: 2022/02/24 09:45
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
@Mapper
public interface DemoDao {

    public Long query(Long id);
}
