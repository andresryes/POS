package Models;

public class User {

    private int idUser;
    private String role;
    private String username;
    private String password;

    public User(int idUser, String role, String username, String password) {
        this.idUser = idUser;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
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
}
