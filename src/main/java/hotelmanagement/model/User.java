package hotelmanagement.model;

import java.util.UUID;

/**
 * Базов клас User, който представя всеки потребител в системата.
 * От този клас ще наследяват: Admin, Owner, Manager, Receptionist и Client.
 */
public abstract class User {

    private String id;
    private String name;
    private String email;
    private String password;
    private String role;

    /**
     * Конструктор по подразбиране – генерира уникално ID.
     */
    public User() {
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Конструктор с параметри.
     */
    public User(String name, String email, String password, String role) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
