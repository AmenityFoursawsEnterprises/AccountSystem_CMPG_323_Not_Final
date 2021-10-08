package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Miles;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel( value = "Miles", description = "A DTO that represents the Miles table.")

public class MilesDto implements  Serializable{
    private static final long serialVersionUID = -4485402550281274533L;

    private Long total_miles;
    private LocalDate startDate;

    public MilesDto() {
    }

    public MilesDto(Long total_miles, LocalDate startDate) {
        this.total_miles = total_miles;
        this.startDate = startDate;
    }
    //moet hier by kom...
    public MilesDto(Miles miles) {
        this.setTotal_miles(miles.getTotal_miles());
        this.setStartDate(miles.getStartDate());
    }

    public Long getTotal_miles() {
        return total_miles;
    }

    public void setTotal_miles(Long total_miles) {
        this.total_miles = total_miles;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilesDto milesDto = (MilesDto) o;
        return Objects.equals(total_miles, milesDto.total_miles) && Objects.equals(startDate, milesDto.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total_miles, startDate);
    }

    @Override
    public String toString() {
        return "MilesDto{" +
                "total_miles=" + total_miles +
                ", startDate=" + startDate +
                '}';
    }
}
