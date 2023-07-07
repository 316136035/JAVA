package vip.tao.Oom.Oom2;


import java.util.List;

public class Mybatis_Role2 {


    @Override
    public String toString() {
        return "Mybatis_Role2{" +
                "dept_Id=" + dept_Id +
                ", rolename='" + rolename + '\'' +
                ", user2List=" + user2List +
                '}';
    }

    public int dept_Id;
    public String rolename;
    public List<Mybatis_User2> user2List;

    public int getDept_Id() {
        return dept_Id;
    }

    public void setDept_Id(int dept_Id) {
        this.dept_Id = dept_Id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<Mybatis_User2> getUser2List() {
        return user2List;
    }

    public void setUser2List(List<Mybatis_User2> user2List) {
        this.user2List = user2List;
    }
}