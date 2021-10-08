package za.ac.nwu.ac.repo.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Rewards;

import java.util.List;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Long>{
    //The private can not be placed on this page.
    // private static final Logger LOGGER = LoggerFactory.getLogger(RewardsRepository.class);

    @Query(value = "SELECT REWARD_NAME, MILES_COUNT, CURRENCY_VALUE, DESCRIPTION,COMPANY"+
            " FROM HR.REWARDS"+
            " WHERE REWARD_NAME = :rewardName", nativeQuery = true
    )
    List<Rewards> getRewardByName(String rewardName);

    //This did not work.
    @Query(value = "SELECT REWARD_NAME, MILES_COUNT, CURRENCY_VALUE, DESCRIPTION,COMPANY"+
            " FROM HR.REWARDS", nativeQuery = true
    )
    Rewards getAll();
}
