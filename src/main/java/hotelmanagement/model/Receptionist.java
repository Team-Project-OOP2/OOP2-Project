package hotelmanagement.model;

public class Receptionist extends User {
    public Receptionist(String name, String email, String password) {
        super(name, email, password, "RECEPTIONIST");
    }
}
