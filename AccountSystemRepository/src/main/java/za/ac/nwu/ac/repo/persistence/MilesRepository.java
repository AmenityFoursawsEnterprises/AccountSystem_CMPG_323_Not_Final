package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.domain.persistence.Miles;

import java.time.LocalDate;

@Repository
public interface MilesRepository extends JpaRepository<Miles, Long> {

    //Eerste poging
    /*@Query(value = "SELECT new za.ac.nwu.ac.domain.dto.MilesDto( "+
            "at.total_miles)"+
            " FROM " +
            "Miles at" +
            "WHERE at.miles_ID = :miles_id"
    )*/
    @Query(value = "SELECT MILES_ID, TOTAL_MILES, START_DATE FROM HR.MILES" +
            "  WHERE MILES_ID = :miles_id ", nativeQuery = true
    )
    Miles getTotalMilesByID(Long miles_id);

    //Eerste poging
    /*@Query(value = "SELECT new za.ac.nwu.ac.domain.dto.MilesDto"+
                    "at.total_miles"+
                    " FROM "+
                    "Miles at" +
                    "WHERE at.miles_ID = :milesID"
    )*/
    //Tweede probeerslag
    /*@Query(value = "UPDATE za.ac.nwu.ac.domain.persistence.Miles"+
            "SET total_miles = total_miles + :milesToAdd"+
            "startDate = :startDate"+
            "WHERE miles_ID = :milesID"
    )*/
    //Derde poging
    /*@Query(value = "UPDATE HR.MILES" +
            " SET TOTAL_MILES = TOTAL_MILES + :milesToAdd," +
            " START_DATE = :startDate"+
            " WHERE MILES_ID = :milesID", nativeQuery = true
    )*/
    @Query(value = "UPDATE HR.MILES"+
            " SET MILES_ID = MILES_ID, TOTAL_MILES = TOTAL_MILES + :milesToAdd,"+
            " START_DATE = CAST(':startDate' AS DATE)"+
            " WHERE MILES_ID = :milesID", nativeQuery = true
    )
    Miles addMiles(Long milesID, Long milesToAdd, LocalDate startDate);

    /*@Query(value = "UPDATE za.ac.nwu.ac.domain.persistence.Miles("+
            "SET mi.total_miles = mi.total_miles - :milesToSubtract)"+
            "FROM Miles mi"+
            "WHERE mi.miles_ID = :milesID"
    )*/
    @Query(value = "UPDATE HR.MILES" +
            " SET TOTAL_MILES = TOTAL_MILES - :milesToSubtract" +
            " WHERE MILES_ID = :milesID", nativeQuery = true
    )
    Miles subtractMiles(Long milesID, Long milesToSubtract);
}
