package vip.taoshenjia.A04_Model实体类;

public class Address {
    private  Integer id;
    private  Integer pid;
    private  String name;
    private  Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public Address(Integer id, Integer pid, String name, Integer level) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.level = level;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }



}
