package com.sql_exp.pojo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Check {
    private Integer managerId;
    private String roomId;
    private Integer userId;
}
