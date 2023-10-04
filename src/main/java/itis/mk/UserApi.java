package itis.mk;

import java.util.List;

public class UserApi {
    private UserRepository userRepository;

    public UserApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserModel user) {
        userRepository.save(user);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public List<UserModel> getUsersByAge(int age) {
        return userRepository.getUsersByAge(age);
    }

    public UserModel getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}