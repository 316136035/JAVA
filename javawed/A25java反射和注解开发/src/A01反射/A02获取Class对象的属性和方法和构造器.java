package A01反射;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class A02获取Class对象的属性和方法和构造器 {
    public static void main(String[] args) throws Exception {
        Class<?> forNamClass = Class.forName("A01反射.Ren");

        /**获取Class类的单个属性*/
        Field name = forNamClass.getDeclaredField("name");
        System.out.println(name.getName());



        /**获取Class类的多个属性*/
        Field[] declaredFields = forNamClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }



        /**获取Class类的单个方法*/
        //get方法写法
        Method getName = forNamClass.getDeclaredMethod("getName", new Class[]{});
        System.out.println(getName.getName());
        //set方法写法
        Method setName = forNamClass.getDeclaredMethod("setName", new Class[]{String.class});
        System.out.println(setName.getName());



        /**获取Class类的多个方法*/
        Method[] declaredMethods = forNamClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }


        /**获取Class类的单个构造器没有参数*/
        Constructor<?> declaredConstructor1 = forNamClass.getDeclaredConstructor(new Class[]{});
        System.out.println( declaredConstructor1 );
        /**获取Class类的单个构造器有参数*/
        Constructor<?> declaredConstructor2 = forNamClass.getDeclaredConstructor(new Class[]{String.class, int.class, String.class});
        System.out.println( declaredConstructor2);


        /**获取Class类的多个构造器*/
        Constructor<?>[] declaredConstructors = forNamClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }


    }
}
