package Model实体类;

public class 地址对象 {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    @Override
    public String toString() {
        return "地址对象{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int id;
    private int pid;
    private String name;
    private int level;

    public 地址对象(int id, int pid, String name, int level) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.level = level;
    }
}
