package za.ac.nwu.ac.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.RewardsDto;
import za.ac.nwu.ac.domain.persistence.Rewards;
import za.ac.nwu.ac.repo.persistence.RewardsRepository;
import za.ac.nwu.ac.translator.RewardsTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class RewardsTranslatorImpl implements RewardsTranslator {
    private static final Logger LOGGER = LoggerFactory.getLogger(RewardsTranslatorImpl.class);

    private final RewardsRepository rewardsRepository;

    @Autowired
    public RewardsTranslatorImpl (RewardsRepository rewardsRepository){
        this.rewardsRepository = rewardsRepository;
    }

    @Override
    public List<RewardsDto> getAllRewards(){
        List<RewardsDto> rewardsDto = new ArrayList<>();
        try{
            for (Rewards rewards: rewardsRepository.findAll()){
                rewardsDto.add(new RewardsDto(rewards));
            }
        }catch (Exception e){
            //TODO: Get All Rewards
            throw new RuntimeException("Unable to read Rewards from the database.", e);
        }
        return rewardsDto;
    }

    @Override
    public List<RewardsDto> getRewardByName(String rewardName){
        List<RewardsDto> rewardsDto = new ArrayList<>();
        try {
            /*Rewards reward = rewardsRepository.getRewardByName(rewardName);
            return new RewardsDto(reward);*/
            for (Rewards rewards: rewardsRepository.getRewardByName(rewardName)){
                rewardsDto.add(new RewardsDto(rewards));
            }
        }catch (Exception e) {
            //TODO: Reward By Name
            throw new RuntimeException("Unable to read reward by name from Database.", e);
        }
        return rewardsDto;
    }
}
