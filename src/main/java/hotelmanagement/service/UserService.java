package hotelmanagement.service;

import hotelmanagement.model.User;
import hotelmanagement.repository.UserRepository;

import java.util.List;

public class UserService {

    private static UserService instance;

    private final UserRepository userRepository = UserRepository.getInstance();

    private UserService() {}

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void registerUser(User user) {
        userRepository.addUser(user);
    }

    public void addUser(User user) {
        registerUser(user);
    }

    public void updateUser(User user) {
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User login(String email, String password) {
        for (User u : getAllUsers()) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void deleteUser(String id) {
        userRepository.deleteUser(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.getAllUsers().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
