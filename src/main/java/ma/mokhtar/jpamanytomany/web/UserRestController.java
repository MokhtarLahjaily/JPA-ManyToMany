package ma.mokhtar.jpamanytomany.web;

import ma.mokhtar.jpamanytomany.entities.User;
import ma.mokhtar.jpamanytomany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users(){
        return userService.listUsers();
    }

    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user = userService.findUserByUserName(username);
        return user;
    }



}
