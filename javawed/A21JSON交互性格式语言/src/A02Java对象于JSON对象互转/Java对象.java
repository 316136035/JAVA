package A02Java对象于JSON对象互转;



public class Java对象 {

    public  int getSku() {
        return sku;
    }

    @Override
    public String toString() {
        return "Java对象{" +
                "sku=" + sku +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public void setSku( int sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Java对象( int sku, String name, Double money) {
        this.sku = sku;
        this.name = name;
        this.money = money;
    }

    private int sku;
    private String name;
    private Double money;

}
