package A04_实体类;

public class Jd {
    private Long id;
    private String name;
    private double money;
    private double enterprisemoney;
    private  int gender;

    @Override
    public String toString() {
        return "Jd{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", enterprisemoney=" + enterprisemoney +
                ", gender=" + gender +
                '}';
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Jd(Long id, String name, double money, double enterprisemoney, int gender) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.enterprisemoney = enterprisemoney;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getEnterprisemoney() {
        return enterprisemoney;
    }

    public void setEnterprisemoney(double enterprisemoney) {
        this.enterprisemoney = enterprisemoney;
    }

    public Jd(Long id, String name, double money, double enterprisemoney) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.enterprisemoney = enterprisemoney;
    }
}
