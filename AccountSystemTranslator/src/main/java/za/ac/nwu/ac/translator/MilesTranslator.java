package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MilesDto;

import java.time.LocalDate;

public interface MilesTranslator {
    MilesDto getTotalMilesByID(Long miles_id);

    MilesDto addMiles(Long miles_id,Long milesToAdd, LocalDate startDate);

    MilesDto subtractMiles(Long MilesID, Long MilesToSubtract);
}
