package lt.codeacademy.alis.api.entity;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "License UUID", required = true, name = "id")
    private UUID id;

    @NotBlank
    @ApiModelProperty(notes = "License name", required = true, name = "name")
    private String name;

    @ApiModelProperty(notes = "License number", required = true, name = "nr")
    private Integer nr;

    @ApiModelProperty(notes = "License term days", required = true, name = "termdays")
    private Integer termdays;

    @ApiModelProperty(notes = "License price", required = true, name = "price")
    private BigDecimal price;

    @Size(max = 255)
    @ApiModelProperty(notes = "License description", required = true, name = "description")
    private String description;

}

