package com.sql_exp.controller;

import com.sql_exp.pojo.Result;
import com.sql_exp.pojo.obj.Manager;
import com.sql_exp.pojo.obj.Room;
import com.sql_exp.pojo.obj.User;
import com.sql_exp.pojo.req.BookInfo;
import com.sql_exp.pojo.req.Check;
import com.sql_exp.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @PostMapping("/bookRoom")
    public Result bookRoom(@RequestBody BookInfo bookInfo) {
        System.out.println(bookInfo);
        commonService.bookRoom(bookInfo);
        return Result.success();
    }

    @PutMapping("/checkin")
    public Result checkin(@RequestBody Check check) {
        String roomId = check.getRoomId();
        Integer userId = check.getUserId();
        System.out.println(roomId + "\n" + userId);
        commonService.checkin(check);
        return Result.success();
    }

    @PutMapping("/checkout")
    public Result checkout(@RequestBody Check check) {
        String roomId = check.getRoomId();
        Integer userId = check.getUserId();
        System.out.println(roomId + "\n" + userId);
        commonService.checkout(check);
        return Result.success();
    }

    @GetMapping("/roomList")
    public Result roomList(@RequestParam(required = false) Integer permission,
                           @RequestParam(required = false) Integer status,
                           @RequestParam(required = false) String type,
                           @RequestParam(required = false) Integer page,
                           @RequestParam(required = false) Integer pageSize) {
        System.out.println(permission + "\n" + status + "\n" + type + "\n" + page + "\n" + pageSize);
//        List<Room> roomList = new ArrayList<>();
//        roomList.add(new Room("101", "大床房", 100.0, (byte) 0));
//        roomList.add(new Room("102", "大床房", 100.0, (byte) 1));
//        roomList.add(new Room("103", "大床房", 100.0, (byte) 2));
//        roomList.add(new Room("104", "大床房", 100.0, (byte) 3));

        return Result.success(commonService.getRoomList(permission, status, type, page, pageSize));
    }

    @GetMapping("/userList")
    public Result userList(@RequestParam(required = false) Integer status, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        System.out.println(status + "\n" + page + "\n" + pageSize);
//        List<User> userList = new ArrayList<>();
//        userList.add(new User(1, "李四", "136......", (byte) 1, "101"));
//        userList.add(new User(2, "李四", "136......", (byte) 2, "102"));
//        userList.add(new User(3, "李四", "136......", (byte) 1, "103"));
//        userList.add(new User(4, "李四", "136......", (byte) 2, "104"));

        return Result.success(commonService.getUserList(status,page,pageSize));
    }

    @GetMapping("/getManager")
    public Result getManager(Integer id) {
//        Manager manager = new Manager("1", "张三", "136......", (byte) 0);
        return Result.success(commonService.getManager(id));
    }

}
