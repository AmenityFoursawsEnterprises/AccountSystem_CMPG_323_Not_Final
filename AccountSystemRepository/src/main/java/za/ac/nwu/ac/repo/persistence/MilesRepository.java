package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.domain.persistence.Miles;

@Repository
public interface MilesRepository extends JpaRepository<Miles, Long> {

    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.MilesDto( "+
            "at.total_miles"+
            " FROM " +
            "Miles at" +
            "WHERE at.miles_ID = :miles_id"
    )
    MilesDto getTotalMilesByID(Long miles_id);

    //Eerste poging
    /*@Query(value = "SELECT new za.ac.nwu.ac.domain.dto.MilesDto"+
                    "at.total_miles"+
                    " FROM "+
                    "Miles at" +
                    "WHERE at.miles_ID = :milesID"
    )*/
    @Query(value = "UPDATE za.ac.nwu.ac.domain.persistence.Miles"+
            "SET total_miles = total_miles + :milesToAdd"+
            "WHERE miles_ID = :milesID"
    )
    Miles addMiles(Long milesID, Long milesToAdd);

    @Query(value = "UPDATE za.ac.nwu.ac.domain.persistence.Miles"+
            "SET total_miles = total_miles - :milesToSubtract"+
            "WHERE miles_ID = :milesID"
    )
    Miles subtractMiles(Long milesID, Long milesToSubtract);
}
