package lt.codeacademy.alis.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */
@Getter
@Setter
@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;

}
