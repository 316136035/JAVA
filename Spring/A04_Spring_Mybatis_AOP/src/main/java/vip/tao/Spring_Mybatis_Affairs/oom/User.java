package vip.tao.Spring_Mybatis_Affairs.oom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data                   //get，set，toString
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
public class User {
    private int User_id;
    private String User_name;
    private String User_password;
    private int Dep_id;
    private Date Creation_time;
    private Date Updated_by;
    private Date Update_time;


}
