package com.zzx.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Mr.John on 2018/9/18 9:47.
 **/

@ToString
@Data
public class GirlEntity {
    private int id;
    private String cupSize;
    private int age;
    private int userId;
    private int height;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
