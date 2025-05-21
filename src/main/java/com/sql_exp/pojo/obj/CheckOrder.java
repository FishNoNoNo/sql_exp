package com.sql_exp.pojo.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOrder {
    private Integer checkId;
    private Integer managerId;
    private String roomId;
    private Integer userId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public CheckOrder(Integer managerId, String roomId, Integer userId) {
        this.managerId = managerId;
        this.roomId = roomId;
        this.userId = userId;
    }
}
