import org.w3c.dom.ls.LSOutput;

public class A02使用接口多态考核老师 {
    public static void main(String[] args) {
        /**子类的实例付给父类引用*/
        Teacher javaTeacher = new JavaTeacher("Java老师");
        /**子类的实例付给父类引用*/
        Teacher phpTeacher = new PhpTeacher("Php老师");
        /**调用考察的方法*/
        ChaTeacher.chaTeacher(javaTeacher);
        System.out.println("---------------------------");
        /**调用考察的方法*/
        ChaTeacher.chaTeacher(phpTeacher);


    }
}

/**定义老师的接口*/
interface Teacher {
    public void teach();
}

/** JavaTeacher实现接口*/
class JavaTeacher implements Teacher {

    public String getName() {
        return name;
    }

    private String name;

    public JavaTeacher(String name) {
        this.name = name;
    }

    @Override
    public void teach() {
        System.out.println("JavaTeacher开始讲课");
    }
}
/** PhpTeacher实现接口*/
class PhpTeacher implements Teacher {
    private String name;

    public String getName() {
        return name;
    }

    public PhpTeacher(String name) {
        this.name = name;
    }

    @Override
    public void teach() {

       System.out.println("PhpTeacher 开始讲课");
    }
}

/**定义考察官*/
class ChaTeacher {
    /**考察的方法*/
    public static void chaTeacher(Teacher teacher) {
        System.out.println("开始考察");

        /**子类转成父类也可以通过instanceof来判断对象的真身类型*/
        if (teacher instanceof JavaTeacher) {
            /**强转为子类的实例*/
            JavaTeacher javaTeacher = (JavaTeacher) teacher;
            //获取属性
            System.out.println(javaTeacher.getName());
            //调用子类方法
            javaTeacher.teach();


        }
        /**子类转成父类也可以通过instanceof来判断对象的真身类型*/
        if (teacher instanceof PhpTeacher) {
            /**强转为子类的实例*/
            PhpTeacher phpTeacher = (PhpTeacher) teacher;
            //获取属性
            System.out.println(phpTeacher.getName());
            //调用子类方法
            phpTeacher.teach();
        }

        System.out.println("考察结束");

    }


}

