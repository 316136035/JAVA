package A01反射;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class A05使用Class反射对象贝对象 {
    public static void main(String[] args) throws ClassNotFoundException {

        Ren ren = new Ren("周先生", 16, "广东");
        copyObject( ren);



    }

    public static Object copyObject(Object o) {
        //获取传进来的对象的反射对象Class
        Class<?> ObjectClass = o.getClass();
        try {
            //通过反射对象Class 获取构造器
            Constructor<?> declaredConstructor = ObjectClass.getDeclaredConstructor(null);
            //通过反射对象Class的构造器创建对象
            Object Instance = declaredConstructor.newInstance(null);
            //通过反射对象Class获取对象的全部属性
            Field[] declaredFields = ObjectClass.getDeclaredFields();
            //遍历反射Class对象的全部属性
            for (Field declaredField : declaredFields) {
                //获取每一个属性的名字
                String  Fieldname= declaredField.getName();
                //截取出来属性的名字首字符小写改成大写；
                Fieldname  =  Fieldname .substring(0, 1).toUpperCase()+ Fieldname.substring(1, Fieldname.length());
                //拼接get方法的全名
                String getname  = "get" + Fieldname;
                //拼接set方法的全名
                String setname = "set" + Fieldname;
                //通过方法名字获取Get方法
                Method getdeclaredMethod = ObjectClass.getDeclaredMethod(getname, null);
                System.out.println(getdeclaredMethod.getName());
                //通过方法名字获取Set方法(方法名字,属性类型)
                Method setdeclaredMethod = ObjectClass.getDeclaredMethod(setname, declaredField.getType());
                System.out.println(setdeclaredMethod .getName());
                //通过反射调用get方法,获取属性值
                Object getinvoke = getdeclaredMethod.invoke( o, null);
                //通过反射调用set方法,设置属性值(反射创建的对象,属性值)
                setdeclaredMethod.invoke(Instance,new Object[]{ getinvoke});



            }

            System.out.println(Instance);




        } catch (Exception e) {
            e.printStackTrace();
        }


        return o;
    }




}
