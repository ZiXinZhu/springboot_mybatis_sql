package com.zzx.entity;

/**
 * Created by Mr.John on 2018/9/20 16:03.
 **/
public class UserEntity {
    private int id;
    private String name;
    private String password;
    private long created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}
