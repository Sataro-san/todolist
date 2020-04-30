package kg.itacademy.securitylesson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleModel {
    private String roleName;
    private Long userId;
}
