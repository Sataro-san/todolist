package kg.itacademy.securitylesson.service;

import kg.itacademy.securitylesson.entity.UserRole;
import kg.itacademy.securitylesson.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    List<UserRole> findAll();
    UserRole create(UserRole userRole);
    UserRole create(UserRoleModel userRoleModel);
}
