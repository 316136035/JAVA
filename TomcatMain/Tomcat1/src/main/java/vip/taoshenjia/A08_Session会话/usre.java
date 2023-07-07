package vip.taoshenjia.A08_Session会话;

public class usre {
    String  usrename;
    String password;

    public String getUsrename() {
        return usrename;
    }

    public void setUsrename(String usrename) {
        this.usrename = usrename;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "usre{" +
                "usrename='" + usrename + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public usre(String usrename, String password) {
        this.usrename = usrename;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
