package model对应数据库的实体类;

import java.sql.Timestamp;

public class JD {


    public JD(long sku, String name, double monovalent1, double monovalent2, Timestamp times) {
        this.sku = sku;
        this.name = name;
        this.monovalent1 = monovalent1;
        this.monovalent2 = monovalent2;
        this.times = times;
    }

    private long sku;
    private String name;
    private double monovalent1;
    private double monovalent2;
    private Timestamp times;

    @Override
    public String toString() {
        return "JD{" +
                "sku=" + sku +
                ", name='" + name + '\'' +
                ", monovalent1=" + monovalent1 +
                ", monovalent2=" + monovalent2 +
                ", times=" + times +
                '}';
    }

    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonovalent1() {
        return monovalent1;
    }

    public void setMonovalent1(double monovalent1) {
        this.monovalent1 = monovalent1;
    }

    public double getMonovalent2() {
        return monovalent2;
    }

    public void setMonovalent2(double monovalent2) {
        this.monovalent2 = monovalent2;
    }

    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
    }
}
