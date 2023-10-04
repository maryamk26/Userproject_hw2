package itis.mk;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepImp();

        UserApi userApi = new UserApi(userRepository);

        UserModel user = new UserModel();
        user.setId(2);
        user.setName("ecf");
        user.setSurname("ecf");
        user.setAge(26);
        user.setEmail("r3f@example.com");
        user.setPassword("3rf");

        userApi.saveUser(user);

        List<UserModel> allUsers = userApi.getAllUsers();
        System.out.println("All Users:");
        for (UserModel u : allUsers) {
            System.out.println(u);
        }

        int age = 25;
        List<UserModel> usersByAge = userApi.getUsersByAge(age);
        System.out.println("Users with age " + age + ":");
        for (UserModel u : usersByAge) {
            System.out.println(u);
        }

        String email = "johndoe@example.com";
        UserModel userByEmail = userApi.getUserByEmail(email);
        System.out.println("User with email " + email + ":");
        System.out.println(userByEmail);
    }
}