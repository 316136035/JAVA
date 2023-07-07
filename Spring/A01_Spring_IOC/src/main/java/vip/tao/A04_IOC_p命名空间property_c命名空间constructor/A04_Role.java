package vip.tao.A04_IOC_p命名空间property_c命名空间constructor;

public class A04_Role {

 private int Dep_id;
 private String role;

 public A04_Role(int dep_id, String role) {
  System.out.println("A02_Role "+ "有参构造器创建了..");
  this.Dep_id = dep_id;
  this.role = role;
 }

 public A04_Role() {
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