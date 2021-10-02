package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Miles;

import java.io.Serializable;
import java.util.Objects;

@ApiModel( value = "Miles", description = "A DTO that represents the Miles table.")

public class MilesDto implements  Serializable{
    private static final long serialVersionUID = -4485402550281274533L;

    private Long total_miles;

    public MilesDto() {
    }

    public MilesDto(Long total_miles) {
        this.total_miles = total_miles;
    }
    public MilesDto(Miles miles) {
        this.total_miles = miles.getTotal_miles();
    }
    @ApiModelProperty(position = 1,
            value = "Miles Total",
            name = "total_miles",
            notes = "The total miles in that miles account.",
            dataType = "java.lang.Long",
            example = "500",
            required = true
    )
    public Long getTotal_miles() {
        return total_miles;
    }

    public void setTotal_miles(Long total_miles) {
        this.total_miles = total_miles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilesDto milesDto = (MilesDto) o;
        return Objects.equals(total_miles, milesDto.total_miles);
    }
    @JsonIgnore//This lets you hide certain parts of the Miles for security purposes by not allowing DB entities to be exposed to the client
    public Miles getMiles(){
        return new Miles(getTotal_miles());
    }
    /*@JsonIgnore
    public Miles getMilesById(Long MilesID){
        if MilesID ==
    }*/
    @Override
    public int hashCode() {
        return Objects.hash(total_miles);
    }

    @Override
    public String toString() {
        return "MilesDto{" +
                "total_miles=" + total_miles +
                '}';
    }
}
