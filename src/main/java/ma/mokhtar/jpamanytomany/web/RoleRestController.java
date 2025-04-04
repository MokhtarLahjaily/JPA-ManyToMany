package ma.mokhtar.jpamanytomany.web;

import ma.mokhtar.jpamanytomany.entities.Role;
import ma.mokhtar.jpamanytomany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleRestController {
    @Autowired
    private UserService userService;
    @GetMapping("/roles")
    public List<Role> roles(){
        return userService.listRoles();
        }

    @GetMapping("/roles/{roleName}")
    public Role role(@PathVariable String roleName){
        Role role = userService.findRoleByRoleName(roleName);
        return role;
    }
}
