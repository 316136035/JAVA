package A01反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class A01获取Class反射对象的三种方法 {
    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println("........第一种通过路径来获取........");
        Class<?> aClass = Class.forName("A01反射.Ren");
        //通过Class获取类属性
        for (Field declaredField : aClass.getDeclaredFields()) {
            System.out.println(declaredField.getName());
        }



        System.out.println("........ /**第二种通过类名*/........");
        Class<Ren> renClass = Ren.class;
        //通过Class获取类方法
        for (Method declaredMethod : renClass.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }



        System.out.println("........  /**第三种通过转进来的对象*/........");
        Ren ren = new Ren();
        通过转进来的对象(ren);

    }

    public static void 通过转进来的对象(Object object) {
        //通过Class获取类构造器
        Class<?> aClass = object.getClass();
        for (Constructor<?> declaredConstructor : aClass.getDeclaredConstructors()) {
            System.out.println(declaredConstructor. getName());

        }


    }


}
