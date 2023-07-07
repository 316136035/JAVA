package vip.tao.A03_IOC_容器xml创建对象.A03_Oom实体类;

import java.util.*;

public class A03_User {

    private String name;
    private  int age;
    private  A03_Role address;
    private  String[] books;
    private  String  IfNull;
    private List<String>  list;
    private Map<String,Object>   map;
    private Set<String>  set;
    private Properties properties;

    public String getIfNull() {
        return IfNull;
    }

    public void setIfNull(String ifNull) {
        IfNull = ifNull;
    }


    public A03_User() {
        System.out.println("A02_User:"+"无参构造器创建了");
    }

    public A03_User(A03_Role address) {

        this.address = address;
    }



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "A03_User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", books=" + Arrays.toString(books) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", properties=" + properties +
                '}';
    }



    public A03_Role getAddress() {
        return address;
    }

    public void setAddress(A03_Role address) {
        this.address = address;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }



    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setName(String name) {
        this.name = name;
    }
}
