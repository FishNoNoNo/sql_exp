package com.sql_exp.service;

import com.sql_exp.pojo.obj.Manager;
import com.sql_exp.pojo.obj.Room;
import com.sql_exp.pojo.obj.User;
import com.sql_exp.pojo.req.BookInfo;
import com.sql_exp.pojo.req.Check;

import java.util.List;

public interface CommonService {
    void bookRoom(BookInfo bookInfo);

    void checkin(Check check);

    void checkout(Check check);

    List<Room> getRoomList(Integer permission,Integer status,String type,Integer page,Integer pageSize);

    List<User> getUserList(Integer status,Integer page,Integer pageSize);

    Manager getManager(Integer id);
}
