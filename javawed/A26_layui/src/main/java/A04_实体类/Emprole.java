package A04_实体类;

public class Emprole {
    @Override
    public String toString() {
        return "Emprole{" +
                "deptid=" + deptid +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    private  int deptid;
    private  String  rolename;

    public Emprole(int deptid, String rolename) {
        this.deptid = deptid;
        this.rolename = rolename;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
