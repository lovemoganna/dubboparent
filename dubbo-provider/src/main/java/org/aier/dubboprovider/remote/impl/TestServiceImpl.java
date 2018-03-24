package org.aier.dubboprovider.remote.impl;

import org.aier.dubboprovider.entity.User;
import org.aier.dubboprovider.remote.TestService;

/**
 * @author: ligang
 * date: 2018/3/23
 * time: 14:56
 */
public class TestServiceImpl implements TestService {
    public User sayHello(long id) {
        return new User();
    }
}
