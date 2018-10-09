package com.zzx.dao;

import com.zzx.entity.GirlEntity;
import com.zzx.entity.HeightEntity;
import com.zzx.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Mr.John on 2018/9/18 9:43.
 **/

@Mapper
public interface GirlDao {

    @Insert("INSERT INTO girl (id,cup_size,age,user_id,height) values (#{id},#{cupSize},#{age},#{userId},#{height})")
    int set(@Param(value = "id") int id,
            @Param(value = "cupSize") String cupSize,
            @Param(value = "age") int age,
            @Param(value = "userId") int userId,
            @Param(value = "height") int height);

    @Select("SELECT a.name,a.password,b.cup_size,b.age,b.height,c.job,c.start_work,c.stop_work from user a inner join girl b on a.id=b.user_id inner join occupation c on b.id=c.girl_id where b.height>=#{height} order by c.start_work asc")
    List<HeightEntity> getHeight(@Param(value = "height") int height);

    @Select("SELECT a.name,a.password,b.cup_size,b.age,b.height,c.job,c.start_work,c.stop_work from user a inner join girl b on a.id=b.user_id inner join occupation c on b.id=c.girl_id " +
            "where b.height=if(#{height}=0,height,#{height})" +
            "AND b.age=if(#{age}=0,age,#{age}) " +
            "AND c.job like if(#{job}='',job,concat('%',#{job},'%')) " +
            "OR a.id like concat('%',#{search},'%')" +
            "OR c.job like concat('%',#{search},'%')" +
            "OR b.height like concat('%',#{search},'%')" +
            "OR a.name like concat('%',#{search},'%') order by c.start_work asc")
    List<HeightEntity> getUnClean(@Param(value = "height") int height,
                                  @Param(value = "age") int age,
                                  @Param(value = "job") String job,
                                  @Param(value = "search") String search);

    @Select("SELECT * FROM user where name like if(#{name}='',name,concat('%',#{name},'%'))")
    List<UserEntity> getUser(@Param("name")String name);

    @Select("SELECT * FROM girl where age=if(#{age}=0,age,#{age})")
    List<GirlEntity> getgirl(@Param("age")int age);


}
