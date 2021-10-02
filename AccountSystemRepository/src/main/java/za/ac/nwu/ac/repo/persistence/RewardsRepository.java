package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Rewards;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Long>{
    Rewards getRewardByName(String rewardName);
}
