package com.cn.oom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User1 {

    /****/
    private int User_id;
    private String User_name;
    private String User_password;
    private int Dep_id;
    private Date Creation_time;
    private Date Updated_by;
    private Date Update_time;


}
