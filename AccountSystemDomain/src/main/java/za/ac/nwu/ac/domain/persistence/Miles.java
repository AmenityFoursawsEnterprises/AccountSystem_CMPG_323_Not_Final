package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import java.time.LocalDate;

@Entity
@Table(name = "MILES", schema = "HR")
public class Miles implements  Serializable{
    private static final long serialVersionUID = -7382342734199544933L;

    private Long miles_ID;
    private Long total_miles;
    private  LocalDate startDate;

    public Miles() {
    }

    public Miles(Long miles_ID, Long total_miles, LocalDate startDate) {
        this.miles_ID = miles_ID;
        this.total_miles = total_miles;
        this.startDate = startDate;
    }
    public Miles(Long total_miles) {
        this.total_miles = total_miles;
    }

    @Id
    @SequenceGenerator(name= "DEMO_GENERIC_SEQ", sequenceName = "HR.DEMO_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_GENERIC_SEQ")
    @Column(name = "MILES_ID")
    public Long getMiles_ID() {
        return miles_ID;
    }

    public void setMiles_ID(Long miles_ID) {
        this.miles_ID = miles_ID;
    }
    @Column(name = "TOTAL_MILES")
    public Long getTotal_miles() {
        return total_miles;
    }

    public void setTotal_miles(Long total_miles) {
        this.total_miles = total_miles;
    }

    @Column(name = "START_DATE")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Miles miles = (Miles) o;
        return Objects.equals(miles_ID, miles.miles_ID) && Objects.equals(total_miles, miles.total_miles) && Objects.equals(startDate, miles.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(miles_ID, total_miles, startDate);
    }

    @Override
    public String toString() {
        return "Miles{" +
                "miles_ID=" + miles_ID +
                ", total_miles=" + total_miles +
                ", startDate=" + startDate +
                '}';
    }
}
