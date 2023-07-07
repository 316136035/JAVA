package A04_实体类;

import java.sql.Date;

public class Emp {

    public Emp(int empid, String empname, int age, int gender, Date hireDate, int depid, Emprole emprole) {
        this.empid = empid;
        this.empname = empname;
        this.age = age;
        this.gender = gender;
        this.hireDate = hireDate;
        this.depid = depid;
        this.emprole = emprole;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", hireDate=" + hireDate +
                ", depid=" + depid +
                ", emprole=" + emprole +
                '}';
    }

    private int empid;
    private String empname;
    private int age;
    private int gender;
    private Date hireDate;
    private int depid;
    //部门管理
    private  Emprole emprole;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public Emprole getEmprole() {
        return emprole;
    }

    public void setEmprole(Emprole emprole) {
        this.emprole = emprole;
    }
}
