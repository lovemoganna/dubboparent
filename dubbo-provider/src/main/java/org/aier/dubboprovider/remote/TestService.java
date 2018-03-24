package org.aier.dubboprovider.remote;

import org.aier.dubboprovider.entity.User;

/**
 * @author: ligang
 * date: 2018/3/23
 * time: 14:54
 * 测试远程调用的接口
 */
public interface TestService {
    User sayHello(long id);
}
