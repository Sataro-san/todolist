package kg.itacademy.securitylesson.controller;

import kg.itacademy.securitylesson.entity.UserRole;
import kg.itacademy.securitylesson.model.UserRoleModel;
import kg.itacademy.securitylesson.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-role")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAll() {
        return userRoleService.findAll();
    }

    @PostMapping
    public UserRole create(@RequestBody UserRoleModel userRoleModel) {
        return userRoleService.create(userRoleModel);
    }

    @PostMapping("/old")
    public UserRole create(@RequestBody UserRole userRole) {
        return userRoleService.create(userRole);
    }
}
