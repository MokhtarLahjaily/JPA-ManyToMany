package ma.mokhtar.jpamanytomany.repositories;

import ma.mokhtar.jpamanytomany.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);

}
