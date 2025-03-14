package com.kh.boot.domain.vo;



import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode


public class Member {

    private String userId;
    private String userPwd;
    private String userName;
    private String email;
    private String gender;
    private String age;
    private String phone;
    private String address;
    private Date enrollDate;
    private Date modifyDate;
    private String status;


}
