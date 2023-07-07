/**
  实现Cloneable接口就可以复制这个对象
 */
public class Dish implements  Cloneable{

    // 编号
    private int num;
    // 名称
    private String name;

    /**重写 clone方法*/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 单价 价格
    private double price;

    // 使用开发工具 idea  alt + insert 生成属性对应的get和set方法

    public Dish() {}

    public Dish(int num, String name, double price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }

    // 获取num属性的值
    public int getNum() {
        return num;
    }

    // 设置num属性的值
    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
