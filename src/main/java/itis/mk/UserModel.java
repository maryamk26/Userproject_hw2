package itis.mk;
import lombok.Data;

@Data
public class UserModel {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
}