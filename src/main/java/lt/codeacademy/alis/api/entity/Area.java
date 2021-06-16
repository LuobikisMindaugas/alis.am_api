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
@Table(name = "Area")
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    @ApiModelProperty(notes = "Area UUID", required = true, name = "id")
    private UUID id;

    @NotBlank
    @ApiModelProperty(notes = "Area name", required = true, name = "name")
    private String name;

    @ApiModelProperty(notes = "Area 2 day price", required = true, name = "dayprice")
    private BigDecimal dayprice;

    @ApiModelProperty(notes = "Area 1 month price", required = true, name = "monthprice")
    private BigDecimal monthprice;

    @ApiModelProperty(notes = "Area 1 year price", required = true, name = "yearprice")
    private BigDecimal yearprice;


}
