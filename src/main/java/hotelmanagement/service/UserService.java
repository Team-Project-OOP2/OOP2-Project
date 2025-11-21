package hotelmanagement.service;

import hotelmanagement.model.User;
import hotelmanagement.repository.UserRepository;

import java.util.List;

/**
 * Сервизен клас за работа с потребители.
 * Тук е бизнес логиката – валидиране, проверка, обработка на данни.
 */
public class UserService {

    private static UserService instance;

    private final UserRepository userRepository = UserRepository.getInstance();

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void registerUser(User user) {
        userRepository.addUser(user);
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
}
