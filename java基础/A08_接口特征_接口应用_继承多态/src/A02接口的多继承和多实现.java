public class A02接口的多继承和多实现 {
    public static void main(String[] args) {

    }
}

interface  A{

      public  void A();

}
interface  B extends  A{
    public  void B();

}


interface  C extends B{
    public  void C();

}


/**接口的多继承*/
interface  D extends  A,B,C{
    public  void D();

}
/**接口的多实现*/
class  All implements  A,B{
    @Override
    public void A() {

    }

    @Override
    public void B() {

    }
}



