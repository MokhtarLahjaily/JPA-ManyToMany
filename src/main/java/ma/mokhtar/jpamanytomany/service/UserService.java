package ma.mokhtar.jpamanytomany.service;

import ma.mokhtar.jpamanytomany.entities.Role;
import ma.mokhtar.jpamanytomany.entities.User;

import java.util.List;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);
    User authenticate(String username, String password);

    List<User> listUsers();

    List<Role> listRoles();
}
