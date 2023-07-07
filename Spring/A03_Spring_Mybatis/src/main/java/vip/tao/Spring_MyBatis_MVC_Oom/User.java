package vip.tao.Spring_MyBatis_MVC_Oom;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private int User_id;
    private String User_name;
    private String User_password;
    private int Dep_id;
    private Date Creation_time;
    private Date Updated_by;
    private Date Update_time;


}
