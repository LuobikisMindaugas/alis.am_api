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
@Table(name = "Area")
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @NotBlank
    private String name;

    private BigDecimal dayprice;

    private BigDecimal monthprice;

    private BigDecimal yearprice;
}
