package com.sql_exp.mapper;

import com.sql_exp.pojo.obj.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO exp_user (name, phone) VALUES (#{name}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Update("UPDATE exp_user SET status=#{status} WHERE id=#{userId}")
    void updateStatus(Integer userId,Integer status);

    @Select("SELECT COUNT(*) FROM exp_user WHERE phone=#{phone}")
    Integer getUserCount(String phone);

    @Select("SELECT id FROM exp_user WHERE phone=#{phone}")
    Integer getUserId(String phone);

    List<User> selectUsers(Integer status,Integer start,Integer pageSize);

    @Insert("INSERT INTO exp_user_room (user_id,room_id,check_time) VALUES (#{userId},#{roomId},#{checkInTime})")
    void insertCheck(Integer userId, String roomId, LocalDateTime checkTime);

}
