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
    private UUID uuid;

    @NotBlank
    private String name;

    @PositiveOrZero
    @NotNull
    private BigDecimal dayPrice;

    @PositiveOrZero
    @NotNull
    private BigDecimal monthPrice;

    @PositiveOrZero
    @NotNull
    private BigDecimal yearPrice;
}
