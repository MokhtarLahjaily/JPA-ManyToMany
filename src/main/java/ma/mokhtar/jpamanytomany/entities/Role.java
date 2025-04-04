package ma.mokhtar.jpamanytomany.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private String roleId;
    @Column(name = "ROLE_NAME",unique = true,length = 20)
    private String roleName;
    @Column(length = 200,name = "DESCRIPTION")
    private String desc;
    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinTable(name = "USER_ROLE",joinColumns = @JoinColumn(name = "ROLE_ID"),inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<User> users=new ArrayList<>();
}
