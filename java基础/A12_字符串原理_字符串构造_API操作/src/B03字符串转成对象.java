import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B03字符串转成对象 {
    public static void main(String[] args) {
        字符串转成对象("张山----123456789121234568----19----1|李双----9765432110----20----2");


    }

    public static void 字符串转成对象(String str) {
        /**使用正则表达式替换字符串中的空格、回车、换行符、制表符*/
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher matcher = p.matcher(str);
        str = matcher.replaceAll("");

        /**拆分字符串为每一个对象成为字符串数组*/
        String[] split = str.split("\\|");
        /**遍历字符串数组*/
        for (int i = 0; i < split.length; i++) {
            /**创建无参的person对象*/
            Person person = new Person();
            /**判断拆分的字符串是否为空*/
            if (split[i] != null && split[i] != "") {
                /**再次拆分字符串成为数组*/
                String[] split1 = split[i].split("----");
                /**为对象赋值*/
                person.setName(split1[0]);
                /**为对象赋值（并把string转成long）*/
                person.setId(Long.valueOf(split1[1]));
                /**为对象赋值（并把string转成int）*/
                person.setAge(Integer.parseInt(split1[2]));
                /**为对象赋值（并把string转成int）*/
                person.setGendr(Integer.parseInt(split1[3]));
            }

            System.out.println(person.toString());

        }


    }


}

class Person {


    private String name;
    private long id;
    private int age;
    private int gendr;

    public Person() {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gendr = gendr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGendr() {
        return gendr;
    }

    public void setGendr(int gendr) {
        this.gendr = gendr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", gendr=" + gendr +
                '}';
    }
}
