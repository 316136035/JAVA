package A01集合Collection的体系_List_Set.集合的泛型;

public class Person extends   Stuendt{
    private  int  id;

    public Person( int id ,String name, int agr) {
        super(name, agr);
        this.id = id;
    }

    public Person(String name, int agr, int id) {
        super(name, agr);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}'+super.toString();
    }
}
