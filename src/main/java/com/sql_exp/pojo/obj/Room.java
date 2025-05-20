package com.sql_exp.pojo.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String id;
    private String type;
    private Double price;
    private byte status;
}
