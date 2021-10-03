package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MilesDto;

public interface MilesTranslator {
    MilesDto getTotalMilesByID(Long miles_id);

    MilesDto addMiles(Long miles_id,Long milesToAdd);

    MilesDto subtractMiles(Long MilesID, Long MilesToSubtract);
}
