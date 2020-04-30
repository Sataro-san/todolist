package kg.itacademy.securitylesson.service;

import kg.itacademy.securitylesson.entity.User;
import kg.itacademy.securitylesson.model.UserAuth;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User create(User user);
    String getToken(UserAuth userAuth);
    User getByLogin(String login);
}
