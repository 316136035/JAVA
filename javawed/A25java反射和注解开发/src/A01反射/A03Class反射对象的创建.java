package A01反射;

import java.lang.reflect.Constructor;

public class A03Class反射对象的创建 {
    public static void main(String[] args) throws Exception {
        //获得Class反射对象
        Class<?> forNamClass = Class.forName("A01反射.Ren");

        //通过Class反射对象获取类的默认构造器
        Constructor<?> constructor = forNamClass.getConstructor(new Class[]{});
        //通过类的默认构造器创建对象
        Object Instance = constructor.newInstance(new Object[]{});
        System.out.println(Instance);


        //通过Class反射对象获取类的有参构造器
        Constructor<?> constructors = forNamClass.getConstructor(new Class[]{String.class,int.class,String.class});
        //通过类的有参构造器创建对象
        Object Instances = constructors.newInstance(new Object[]{"周先生", 1, "广东"});
        System.out.println(Instances );

    }
}
