package hotelmanagement.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class User {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty password;
    private final StringProperty role;

    public User() {
        this.id = new SimpleStringProperty(java.util.UUID.randomUUID().toString());
        this.name = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.role = new SimpleStringProperty("");
    }

    public User(String name, String email, String password, String role) {
        this.id = new SimpleStringProperty(java.util.UUID.randomUUID().toString());
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.role = new SimpleStringProperty(role);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }
}
