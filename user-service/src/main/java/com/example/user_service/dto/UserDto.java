package com.example.user_service.dto;

import com.example.user_service.vo.ResponseOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String name;
    private  String pwd;
    private String userId;
    private Date createdAt;

    private String encryptedPwd;
    private List<ResponseOrder> orders;
}
