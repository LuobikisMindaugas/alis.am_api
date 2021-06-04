package lt.codeacademy.alis.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;


/**
 * @Author Mindaugas Luobikis
 */

@Getter
@Setter
@Entity
@Table(name = "License")
@NoArgsConstructor
@AllArgsConstructor
public class License {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @NotBlank
    private String name;

    private Integer nr;

    private Integer termdays;

    private BigDecimal price;

    @Size(max = 255)
    private String description;

}

