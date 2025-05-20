package com.sql_exp.service.impl;

import com.sql_exp.pojo.obj.Manager;
import com.sql_exp.pojo.obj.Room;
import com.sql_exp.pojo.obj.User;
import com.sql_exp.service.CommonService;

import java.util.List;

public class CommonServiceImpl implements CommonService {
    @Override
    public void bookRoom(String phone, String name, String roomId) {

    }

    @Override
    public void checkin(String roomId, String userId) {

    }

    @Override
    public void checkout(String roomId, String userId) {

    }

    @Override
    public List<Room> getRoomList(Integer permission, Integer status, String type, Integer page, Integer pageSize) {
        return List.of();
    }

    @Override
    public List<User> getUserList(Integer status, Integer page, Integer pageSize) {
        return List.of();
    }

    @Override
    public Manager getManager(Integer id) {
        return null;
    }
}
