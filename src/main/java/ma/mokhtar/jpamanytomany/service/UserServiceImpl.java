package ma.mokhtar.jpamanytomany.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.mokhtar.jpamanytomany.entities.Role;
import ma.mokhtar.jpamanytomany.entities.User;
import ma.mokhtar.jpamanytomany.repositories.RoleRepository;
import ma.mokhtar.jpamanytomany.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);

    }

    @Override
    public Role addNewRole(Role role) {
        role.setRoleId(UUID.randomUUID().toString());
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = findUserByUserName(userName);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles() != null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepository.save(user);

    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new RuntimeException("Bad Credentials");
        }
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad Credentials");
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

}
