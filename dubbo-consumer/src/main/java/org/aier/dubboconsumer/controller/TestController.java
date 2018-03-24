package org.aier.dubboconsumer.controller;

import org.aier.dubboprovider.entity.User;
import org.aier.dubboprovider.remote.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ligang
 * date: 2018/3/23
 * time: 15:26
 */
@RestController
public class TestController {
    @Autowired
    private TestService service;
    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     *测试dubbo在服务层和表现层之间的通信.
     * @return
     */
    @GetMapping("/test/{id}")
    public User testJson(@PathVariable("id") Long id) {
        User user =null;
        try {
            user = new User();
            user.setUserId(id);
            user.setAge(12);
            user.setUsername("小明");
            user.setCity("河北");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return user;
    }
}
