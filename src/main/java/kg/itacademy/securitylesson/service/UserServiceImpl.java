package kg.itacademy.securitylesson.service;

import kg.itacademy.securitylesson.entity.User;
import kg.itacademy.securitylesson.entity.UserRole;
import kg.itacademy.securitylesson.model.UserAuth;
import kg.itacademy.securitylesson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleService userRoleService;


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_ADMIN");
        userRole.setUser(user);
        userRoleService.create(userRole);

        return user;
    }

    @Override
    public String getToken(UserAuth userAuth) {
        User user = getByLogin(userAuth.getLogin());
        if(user == null) return "Error";
        String rawPassword = userAuth.getPassword(); //1234
        String encodedPassword = user.getPassword(); //$2a$10$6Sjvje7MmdCTUhQySkOfg.hTXT2WAA.tXKr64Sy14iCkSkNMHpTay
        if(passwordEncoder.matches(rawPassword, encodedPassword)) {
            String loginPasswordPair = userAuth.getLogin() + ":" + userAuth.getPassword();//admin:1234
            String token = Base64.getEncoder().encodeToString(loginPasswordPair.getBytes());
            return "Basic " + token;
        }
        return "Error";
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login).orElse(null);
    }
}
