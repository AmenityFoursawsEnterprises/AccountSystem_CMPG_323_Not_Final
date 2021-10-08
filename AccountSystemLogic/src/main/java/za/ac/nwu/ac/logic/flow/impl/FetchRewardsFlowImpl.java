package za.ac.nwu.ac.logic.flow.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.RewardsDto;
import za.ac.nwu.ac.logic.flow.FetchRewardsFlow;
import za.ac.nwu.ac.translator.RewardsTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component("fetchRewardsFlowName")
public class FetchRewardsFlowImpl implements FetchRewardsFlow {
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchRewardsFlowImpl.class);

    private final RewardsTranslator rewardsTranslator;
    @Autowired
    public FetchRewardsFlowImpl(RewardsTranslator rewardsTranslator) {
        this.rewardsTranslator = rewardsTranslator;
    }

    @Override
    public List<RewardsDto> getAllRewards() {
        LOGGER.info("There was no input for the getAllRewards.");
        return rewardsTranslator.getAllRewards();
    }

    @Override
    public List<RewardsDto> getRewardByName(String Name) {
        LOGGER.info("The input for getRewardByName is {}.", Name);
        return rewardsTranslator.getRewardByName(Name);
    }
}
