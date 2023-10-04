package itis.mk;

import java.util.List;

public interface UserRepository {
    void save(UserModel user);

    List<UserModel> getAllUsers();

    List<UserModel> getUsersByAge(int age);

    UserModel getUserByEmail(String email);
}