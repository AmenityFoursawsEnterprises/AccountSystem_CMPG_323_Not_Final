package za.ac.nwu.ac.logic.flow.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.RewardsDto;
import za.ac.nwu.ac.logic.flow.FetchRewardsFlow;
import za.ac.nwu.ac.translator.RewardsTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchRewardsFlowImpl implements FetchRewardsFlow {
 private final RewardsTranslator rewardsTranslator;
 @Autowired
    public FetchRewardsFlowImpl(RewardsTranslator rewardsTranslator) {
     this.rewardsTranslator = rewardsTranslator;
 }
 @Override
    public List<RewardsDto> getAllRewards() {
     return rewardsTranslator.getAllRewards();
 }

    @Override
    public RewardsDto getRewardByName(String Name) {
        return rewardsTranslator.getRewardByName(Name);
    }
}
