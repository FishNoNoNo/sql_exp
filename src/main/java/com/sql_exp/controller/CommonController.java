package com.sql_exp.controller;

import com.sql_exp.pojo.Result;
import com.sql_exp.pojo.req.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommonController {
//    @Autowired
//    private CommonService commonService;

    @PostMapping("/bookRoom")
    public Result bookRoom(@RequestBody BookInfo bookInfo){
        System.out.println(bookInfo);
        return Result.success(1);
    }

    @GetMapping("/checkin")
    public Result checkin(String roomId,String userId){
        System.out.println(roomId+"\n"+userId);
        return Result.success(1);
    }
}
