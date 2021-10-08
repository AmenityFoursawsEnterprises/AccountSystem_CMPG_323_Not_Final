package za.ac.nwu.ac.translator;
import za.ac.nwu.ac.domain.dto.RewardsDto;
import java.util.List;


public interface RewardsTranslator {

    List<RewardsDto> getAllRewards();
    List <RewardsDto> getRewardByName(String Name);
}
