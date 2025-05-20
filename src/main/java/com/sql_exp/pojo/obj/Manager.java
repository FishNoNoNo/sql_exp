package com.sql_exp.pojo.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private String id;
    private String name;
    private String phone;
    private byte permission;
}
