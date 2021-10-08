package za.ac.nwu.ac.logic.flow;
import za.ac.nwu.ac.domain.dto.RewardsDto;

import java.util.List;
public interface FetchRewardsFlow {
    List<RewardsDto> getAllRewards();

    List<RewardsDto> getRewardByName(String name);
}
