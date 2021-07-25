package com.eleven.test.service.impl;

import com.eleven.test.dao.TestDao;
import com.eleven.test.entity.Test;
import com.eleven.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> findAll() {
        return testDao.findAll();
    }
}
