package A03复杂数据类型;

public class Java对象1 {
    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Java对象1{" +
                "sku=" + sku +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
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

    private int sku;
    private String name;
    private double money;

    public Java对象1(int sku, String name, double money) {
        this.sku = sku;
        this.name = name;
        this.money = money;
    }
}
