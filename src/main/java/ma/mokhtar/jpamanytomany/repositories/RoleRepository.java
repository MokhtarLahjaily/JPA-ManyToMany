package ma.mokhtar.jpamanytomany.repositories;

import ma.mokhtar.jpamanytomany.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    Role findByRoleName(String roleName);

}
