package com.zzx.controller;

import com.zzx.dao.GirlDao;
import com.zzx.entity.GirlEntity;
import com.zzx.entity.HeightEntity;
import com.zzx.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mr.John on 2018/9/18 9:49.
 **/
@Api(value = "《前端》-用户管理接口",description = "《前端》-用户管理接口")
@RestController
public class GirlController {

    @Autowired
    private GirlDao userDao;

    @ApiOperation("用户注册接口")
    @PostMapping("/set")
    public String set(GirlEntity userEntity){
        int isSet=userDao.set(userEntity.getId(),userEntity.getCupSize(),userEntity.getAge(),userEntity.getUserId(),userEntity.getHeight());
        if(isSet==1){
            return "成功！";
        }
        return "失败！";
    }

    @GetMapping("/height")
    public List<HeightEntity>  getHeight(@ApiParam("身高") int height){
        List<HeightEntity> heightEntity=userDao.getHeight(height);
        if(heightEntity.size()>0){
            return heightEntity;
        }
        return null;
    }
    @GetMapping("/all")
    public List<HeightEntity>  getSearch(int height,int age,String job,String search){
        List<HeightEntity> heightEntity=userDao.getUnClean(height,age,job,search);
        if(heightEntity.size()>0){
            return heightEntity;
        }
        return null;
    }
    @PostMapping("/getuser")
    public List<UserEntity>  getuser(String name ){
        List<UserEntity> userEntities=userDao.getUser(name);
        return userEntities;
    }
    @PostMapping("/getgirl")
    public List<GirlEntity>  getuser(int age ){
        List<GirlEntity> girlEntities=userDao.getgirl(age);
        return girlEntities;
    }
}
