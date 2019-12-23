package com.nut.ledger.service.impl;

import com.alibaba.fastjson.JSON;
import com.nut.ledger.db.dao.PeopleMapper;
import com.nut.ledger.service.IPeopleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: han jianguo
 * @Date: 2019/12/23 13:48
 * @Description:
 **/
@Service
public class PeopleServiceImpl implements IPeopleService {

    private final Logger logger = LogManager.getLogger(PeopleMapper.class);

    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public String get() {
        logger.info("hello");

        return JSON.toJSONString(peopleMapper.selectByPrimaryKey(1));
    }
}
