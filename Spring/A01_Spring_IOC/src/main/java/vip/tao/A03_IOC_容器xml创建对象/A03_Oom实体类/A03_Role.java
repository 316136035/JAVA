package vip.tao.A03_IOC_容器xml创建对象.A03_Oom实体类;

public class A03_Role {

 private int Dep_id;
 private String role;

 public A03_Role(int dep_id, String role) {
  System.out.println("A02_Role "+ "有参构造器创建了..");
  this.Dep_id = dep_id;
  this.role = role;
 }



 public int getDep_id() {
  return Dep_id;
 }

 public void setDep_id(int dep_id) {
  Dep_id = dep_id;
 }



 @Override
 public String toString() {
  return "A02_Role{" +
          "Dep_id=" + Dep_id +
          ", role='" + role + '\'' +
          '}';
 }

 public String getRole() {
  return role;
 }




}