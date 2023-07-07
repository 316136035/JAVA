package A01集合Collection的体系_List_Set.集合的泛型;

public class Stuendt {
    @Override
    public String toString() {
        return "Stuendt{" +
                "name='" + name + '\'' +
                ", agr=" + agr +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgr() {
        return agr;
    }

    public void setAgr(int agr) {
        this.agr = agr;
    }

    public Stuendt(String name, int agr) {
        this.name = name;
        this.agr = agr;
    }

    private String  name;
    private int agr;

}
