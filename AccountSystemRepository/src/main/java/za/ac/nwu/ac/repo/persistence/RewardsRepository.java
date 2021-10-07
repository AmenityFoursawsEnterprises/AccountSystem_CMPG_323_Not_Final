package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Rewards;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Long>{
    @Query(value = "SELECT REWARD_NAME, MILES_COUNT, CURRENCY_VALUE, DESCRIPTION,COMPANY"+
            " FROM HR.REWARDS"+
            " WHERE REWARD_NAME = :rewardName", nativeQuery = true
    )
    Rewards getRewardByName(String rewardName);
}
