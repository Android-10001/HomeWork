package com.example.greendaolx;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author:Created by jiangkerun on 2018/5/14.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String name;
    private String age;
    private String address;
    @Generated(hash = 951402327)
    public User(Long id, @NotNull String name, String age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
