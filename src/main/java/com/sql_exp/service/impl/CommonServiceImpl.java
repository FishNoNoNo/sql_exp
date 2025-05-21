package com.sql_exp.service.impl;

import com.sql_exp.mapper.ManagerMapper;
import com.sql_exp.mapper.RoomMapper;
import com.sql_exp.mapper.UserMapper;
import com.sql_exp.pojo.obj.CheckOrder;
import com.sql_exp.pojo.obj.Manager;
import com.sql_exp.pojo.obj.Room;
import com.sql_exp.pojo.obj.User;
import com.sql_exp.pojo.req.BookInfo;
import com.sql_exp.pojo.req.Check;
import com.sql_exp.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transient
    public void bookRoom(BookInfo bookInfo) {
        User user = new User(bookInfo.getName(),bookInfo.getPhone());
        Integer id=userMapper.getUserId(bookInfo.getPhone());
        if(id==null){
            userMapper.insert(user);
        }else{
            user.setId(id);
        }

        roomMapper.updateStatus(bookInfo.getRoomId(), 1);
        userMapper.insertCheck(user.getId(),bookInfo.getRoomId(), LocalDateTime.now());
    }

    @Override
    @Transient
    public void checkin(Check check) {
        roomMapper.updateStatus(check.getRoomId(),2);
        userMapper.updateStatus(check.getUserId(),2);
        CheckOrder checkOrder = new CheckOrder(check.getManagerId(),check.getRoomId(),check.getUserId());
        checkOrder.setCheckInTime(LocalDateTime.now());
        managerMapper.insertCheck(checkOrder);
    }

    @Override
    @Transient
    public void checkout(Check check) {
        roomMapper.updateStatus(check.getRoomId(),3);
        userMapper.updateStatus(check.getUserId(),3);
        CheckOrder checkOrder = new CheckOrder(check.getManagerId(),check.getRoomId(),check.getUserId());
        checkOrder.setCheckOutTime(LocalDateTime.now());
        managerMapper.updateCheckOutTime(checkOrder);
    }

    @Override
    public List<Room> getRoomList(Integer permission, Integer status, String type, Integer page, Integer pageSize) {
        if(page==null && pageSize==null){
            page=1;
            pageSize=100;
        }
        Integer start=(page-1)*pageSize;

        if(permission==null){
            return roomMapper.getAllRoomList(status,type,start,pageSize);
        }
        List<String> roomIds=managerMapper.getRoomList(permission);
        return roomMapper.getRoomList(roomIds,status,type,start,pageSize);
    }

    @Override
    public List<User> getUserList(Integer status, Integer page, Integer pageSize) {
        if(page==null && pageSize==null){
            page=1;
            pageSize=100;
        }
        Integer start=(page-1)*pageSize;

        return userMapper.selectUsers(status,start,pageSize);
    }

    @Override
    public Manager getManager(Integer id) {
        return managerMapper.getManagerById(id);
    }
}
