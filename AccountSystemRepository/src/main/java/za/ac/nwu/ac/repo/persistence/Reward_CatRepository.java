package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Reward_Category;

@Repository
public interface Reward_CatRepository extends JpaRepository<Reward_Category, Long>{
}
