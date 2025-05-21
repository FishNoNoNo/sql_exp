package com.sql_exp.mapper;

import com.sql_exp.pojo.obj.CheckOrder;
import com.sql_exp.pojo.obj.Manager;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ManagerMapper {
    @Select("SELECT * FROM exp_manager WHERE id=#{id}")
    Manager getManagerById(Integer id);

    @Select("SELECT room_id FROM exp_service WHERE permission=#{permission}")
    List<String> getRoomList(Integer permission);

    @Insert("INSERT INTO exp_check (manager_id, user_id, room_id, check_in_time) " +
            "VALUES (#{managerId}, #{userId}, #{roomId}, #{checkInTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertCheck(CheckOrder checkOrder);

    @Update("UPDATE exp_check SET check_out_time=#{checkOutTime} WHERE room_id=#{roomId} AND user_id=#{userId} AND check_in_time = (SELECT MAX(check_in_time) FROM exp_check WHERE room_id=#{roomId} AND user_id=#{userId}))")
    void updateCheckOutTime(CheckOrder checkOrder);
}
