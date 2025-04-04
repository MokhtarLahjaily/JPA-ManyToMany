package ma.mokhtar.jpamanytomany;

import ma.mokhtar.jpamanytomany.entities.Role;
import ma.mokhtar.jpamanytomany.entities.User;
import ma.mokhtar.jpamanytomany.service.UserService;
import java.util.stream.Stream;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@SpringBootApplication
public class JpaManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaManyToManyApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User u1 = new User();
            u1.setUsername("mokhtar");
            u1.setPassword("1234");
            userService.addNewUser(u1);

            User u2 = new User();
            u2.setUsername("Youssef");
            u2.setPassword("4321");
            userService.addNewUser(u2);

            Stream.of("STUDENT","ADMIN","USER").forEach(r -> {
                Role role = new Role();
                role.setRoleName(r);
                userService.addNewRole(role);
            });

            userService.addRoleToUser("mokhtar","STUDENT");
            userService.addRoleToUser("mokhtar","USER");
            userService.addRoleToUser("Youssef","ADMIN");
            userService.addRoleToUser("Youssef","USER");

            try{
                User user = userService.authenticate("mokhtar","1234");
                System.out.println("User authenticated: " + user.getUsername());
                System.out.println("Roles: ");
                user.getRoles().forEach(r -> {
                    System.out.println("Role => " + r);
                });
            }catch (Exception e){
                e.printStackTrace();
            }

        };
    }

}
