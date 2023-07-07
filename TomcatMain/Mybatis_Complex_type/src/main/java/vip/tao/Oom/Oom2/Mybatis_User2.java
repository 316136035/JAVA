package vip.tao.Oom.Oom2;

import java.util.Date;

public class Mybatis_User2 {
    @Override
    public String toString() {
        return "Mybatis_User2{" +
                "User_id=" + User_id +
                ", User_name='" + User_name + '\'' +
                ", User_password='" + User_password + '\'' +
                ", Creation_time=" + Creation_time +
                ", Updated_by=" + Updated_by +
                ", Update_time=" + Update_time +
                '}';
    }

    public int User_id;
    public String User_name;
    public String User_password;
    public Date Creation_time;
    public Date Updated_by;
    public Date Update_time;


}