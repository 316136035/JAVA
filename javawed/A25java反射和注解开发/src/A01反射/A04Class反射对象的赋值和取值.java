package A01反射;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class A04Class反射对象的赋值和取值 {
    public static void main(String[] args) throws Exception {
        //获得Class反射对象
        Class<?> forNamClass = Class.forName("A01反射.Ren");

        //通过Class反射对象获取类的默认构造器
        Constructor<?> constructor = forNamClass.getConstructor(new Class[]{});
        //通过类的默认构造器创建对象
        Object Instance = constructor.newInstance(new Object[]{});


        /**通过反射的属性来赋值*/
        Field Fieldname1 = forNamClass.getDeclaredField("name");
        //不能直接设置private参数的值(要设置setAccessible(true))  (private方法也是一样可以破坏)
        //破坏private属性
        Fieldname1.setAccessible(true);
        Fieldname1.set(Instance,"黄先生");
        System.out.println(Instance);

        /**Class反射对象的方法赋值*/

        //通过Class反射对象获取对象的全部方法
        Method[] declaredMethods = forNamClass.getDeclaredMethods();
        //遍历全部方法
        for (Method declaredMethod : declaredMethods) {
            //获取全部方法名字
            String name = declaredMethod.getName();
            //判断方法name是否以set开头
            boolean set = name.startsWith("set");

            if (set){
                //通过方法名字截取属性的名字；
                String Fieldname = name.substring("set".length(), name.length());
                //截取出来属性的名字首字符大写改成小写；
                Fieldname  =  Fieldname .substring(0, 1).toLowerCase()+ Fieldname.substring(1, Fieldname.length());
                //Class反射对象和属性的名字获取属性
                Field declaredField = forNamClass.getDeclaredField( Fieldname);
                //通过属性获取属性类型
                Class<?> type = declaredField.getType();

                //判断属性类型
                if (type==int.class){
                    //invoke调用set方法赋值（对象，参数）
                    declaredMethod.invoke(Instance,new Object[]{1});

                }
                //判断属性类型
                if (type==String.class&&"name".equals( Fieldname)){
                   declaredMethod.invoke(Instance,new Object[]{"周先生"});

                }
                //判断属性类型
                if (type==String.class&&"address".equals( Fieldname)){
                    declaredMethod.invoke(Instance,new Object[]{"广东"});
                }
            }


        }

        /**Class反射对象的方法取值*/
        //获取Class反射对象的全部方法
        Method[] declaredMethods1 = forNamClass.getDeclaredMethods();
        //遍历Class反射对象的全部方法
        for (Method method : declaredMethods1) {
            //判断方法名字是否位get
            if ( method.getName().startsWith("get")){
                //invoke反射调用get方法
                Object invoke = method.invoke(Instance, new Object[]{});

                System.out.println(invoke.toString());
            }
        }

        System.out.println(Instance);

        /**Class反射对的静态方法调用*/
        Method statictext = forNamClass.getDeclaredMethod("statictext", null);
        statictext.invoke(Instance,null);



    }
}
