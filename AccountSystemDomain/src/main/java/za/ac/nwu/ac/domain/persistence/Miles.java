package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MILES", schema = "HR")
public class Miles implements  Serializable{
    private static final long serialVersionUID = 8120527336928069347L;

    private Long miles_ID;
    private Long total_miles;

    public Miles() {
    }

    public Miles(Long miles_ID, Long total_miles) {
        this.miles_ID = miles_ID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Miles miles = (Miles) o;
        return Objects.equals(miles_ID, miles.miles_ID) && Objects.equals(total_miles, miles.total_miles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(miles_ID, total_miles);
    }

    @Override
    public String toString() {
        return "Miles{" +
                "miles_ID=" + miles_ID +
                ", total_miles=" + total_miles +
                '}';
    }
}
