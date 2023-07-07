package com.cn.Model实体类;


public class User {


    public User(Integer id, String username, String password, String permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
    }

    private Integer id ;

    private String username ;

    private String password ;

    private String permission ;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    /** id */
    public Integer getId(){
        return this.id;
    }
    /** id */
    public void setId(Integer id){
        this.id=id;
    }
    /** username */
    public String getUsername(){
        return this.username;
    }
    /** username */
    public void setUsername(String username){
        this.username=username;
    }
    /** password */
    public String getPassword(){
        return this.password;
    }
    /** password */
    public void setPassword(String password){
        this.password=password;
    }
    /** Permission */
    public String getPermission(){
        return this.permission;
    }
    /** Permission */
    public void setPermission(String permission){
        this.permission=permission;
    }


}
