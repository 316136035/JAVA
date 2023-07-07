package A03Object类;

class Jd {
    private long id;
    private String str;
    private double money;

    public Jd(long id, String str, double money) {
        this.id = id;
        this.str = str;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Jd{" +
                "id=" + id +
                ", str='" + str + '\'' +
                ", money=" + money +
                '}';
    }
}

class Equals {
    /**
     * 重写了Object的equals方法
     */
    public static boolean Equals1(Jd sqljd, Jd jd) {
        boolean b = false;
        /**equals是判断引用类型是否相等的(==是判断非引用类型否相等)
         * 当==判断引用类型的时候判断是地址是否相等
         *
         * */
        /**先用instanceof 判断进来的是否是这个对象*/
        if (sqljd != null && jd != null && sqljd instanceof Jd && jd instanceof Jd) {
            if (sqljd.getId() == jd.getId() && sqljd.getStr().equals(jd.getStr()) && sqljd.getMoney() == jd.getMoney()) {
                b = true;
            }

        } else {

            System.out.println("表达式有问题");
        }

        return b;
    }
}

public class A02超类Object的比较对象equals的方法 {
    public static void main(String[] args) {

        Jd 洗发水1 = new Jd(1, "洗发水", 16.99);

        Jd 洗发水2 = new Jd(1, "洗发水", 16.9);

        boolean b = Equals.Equals1(洗发水1, 洗发水2);
        System.out.println(b);


    }
}
