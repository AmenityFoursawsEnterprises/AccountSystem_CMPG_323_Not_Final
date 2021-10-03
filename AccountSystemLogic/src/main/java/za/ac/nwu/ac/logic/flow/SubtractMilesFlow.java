package za.ac.nwu.ac.logic.flow;
import za.ac.nwu.ac.domain.dto.MilesDto;

public interface SubtractMilesFlow {
    MilesDto subtractMiles(Long MilesID, Long MilesToSubtract);
}
