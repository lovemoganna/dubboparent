package org.aier.dubboprovider.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author: ligang
 * date: 2018/3/24
 * time: 8:37
 * 用户实体类
 */
@EntityScan
public class User {
    private long userId;
    private String username;
    private int age;
    private String city;

    public User(long userId, String username, int age, String city) {
        this.userId = userId;
        this.username = username;
        this.age = age;
        this.city = city;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    public long getUserId() {
        return userId;
    }

    public User setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }
}
