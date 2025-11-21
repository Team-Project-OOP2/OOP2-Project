package hotelmanagement.repository;

import hotelmanagement.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository за работа с потребители.
 * Тук по-късно ще има записване/четене от файл.
 * Сега реализираме основната структура по примера на преподавателя.
 */
    public class UserRepository {

    private static UserRepository instance;

    private List<User> users = new ArrayList<>();

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
