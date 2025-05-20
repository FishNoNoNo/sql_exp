package com.sql_exp.service;

import com.sql_exp.pojo.obj.Manager;
import com.sql_exp.pojo.obj.Room;
import com.sql_exp.pojo.obj.User;

import java.util.List;

public interface CommonService {
    void bookRoom(String phone,String name,String roomId);

    void checkin(String roomId,String userId);

    void checkout(String roomId,String userId);

    List<Room> getRoomList(Integer permission,Integer status,String type,Integer page,Integer pageSize);

    List<User> getUserList(Integer status,Integer page,Integer pageSize);

    Manager getManager(Integer id);
}
