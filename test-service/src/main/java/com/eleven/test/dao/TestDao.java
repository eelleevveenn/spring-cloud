package com.eleven.test.dao;

import com.eleven.test.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 启动类获取TestDao的两种方法:
 *      （1） 当前TestDao局部配置注解@Mapper;
 *      （2） 启动类EosApplication全局配置TestDao路径：@MapperScan("com.eleven.eos.business.*.dao");
 */
@Mapper
public interface TestDao {
    List<Test> findAll();
}
