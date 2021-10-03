package za.ac.nwu.ac.logic.flow;
import za.ac.nwu.ac.domain.dto.MilesDto;

public interface AddMilesFlow {
    MilesDto addMiles(Long miles_ID, Long milesToAdd);
}
