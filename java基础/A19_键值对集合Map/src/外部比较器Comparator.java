import java.util.Comparator;
import java.util.Random;


public class 外部比较器Comparator extends Random implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int  retur=  o1.getId()-o2.getId();
        if ( retur==0){
            retur= o1.getName().compareTo(o2.getName());
        }
        return retur;
    }
}
