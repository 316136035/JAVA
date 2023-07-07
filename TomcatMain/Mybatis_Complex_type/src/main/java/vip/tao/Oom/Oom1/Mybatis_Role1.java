package vip.tao.Oom.Oom1;


public class Mybatis_Role1 {

    public int getDept_Id() {
        return dept_Id;
    }

    public void setDept_Id(int dept_Id) {
        this.dept_Id = dept_Id;
    }

    public String getRolename() {
        return rolename;
    }

    @Override
    public String toString() {
        return "Mybatis_Role{" +
                "dept_Id=" + dept_Id +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public int dept_Id;
    public java.lang.String rolename;




}