package com.sql_exp.mapper;

import com.sql_exp.pojo.obj.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoomMapper {

    @Update("UPDATE exp_room SET status=#{status} WHERE id=#{roomId}")
    void updateStatus(String roomId,Integer status);

    List<Room> getRoomList(List<String> roomIdList,Integer status,String type,Integer start,Integer pageSize);

    List<Room> getAllRoomList(Integer status,String type,Integer start,Integer pageSize);
}
