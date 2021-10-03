package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MilesDto;

public interface ViewMilesFlow {
    MilesDto getTotalMilesByID(Long miles_ID);
}
