public class UsernamePassword {
    public String getUsername() {
        return username;
    }

    public UsernamePassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private  String username;
    private  String password;
}
