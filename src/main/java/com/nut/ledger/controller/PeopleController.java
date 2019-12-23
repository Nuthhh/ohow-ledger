package com.nut.ledger.controller;

import com.nut.ledger.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: han jianguo
 * @Date: 2019/12/23 13:50
 * @Description:
 **/
@RestController
public class PeopleController {

    @Autowired
    private IPeopleService peopleService;

    @RequestMapping("/get")
    public String get() {
        return peopleService.get();
    }
}
