package com.sql_exp.pojo.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String phone;
    private byte status;
    private String roomId;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
