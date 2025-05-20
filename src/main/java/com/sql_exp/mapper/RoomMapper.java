package com.sql_exp.mapper;

import com.sql_exp.pojo.obj.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoomMapper {

    @Update("UPDATE exp_room SET status=#{status} WHERE room_id=#{roomId}")
    void updateStatus(String roomId,byte status);

//    @Select("SELECT * FROM exp_room ")
    List<Room> getRoomList(List<String> roomIdList,Integer status,String type,Integer page,Integer pageSize);
}
