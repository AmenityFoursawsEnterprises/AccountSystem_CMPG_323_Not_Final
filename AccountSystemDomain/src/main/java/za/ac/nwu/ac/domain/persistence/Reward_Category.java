package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "REWARD_CATEGORIES", schema = "HR")
public class Reward_Category implements Serializable{
    private static final long serialVersionUID = 7235058633425136463L;
    private Long Category_ID;
    private String Category_Name;
    private Set <Rewards> rewards;

    public Reward_Category() {
    }

    public Reward_Category(Long category_ID, String category_Name) {
        Category_ID = category_ID;
        Category_Name = category_Name;
    }
    @Id
    @SequenceGenerator(name= "DEMO_GENERIC_SEQ", sequenceName = "HR.DEMO_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_GENERIC_SEQ")
    @Column(name = "CATEGORY_ID")
    public Long getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(Long category_ID) {
        Category_ID = category_ID;
    }

    @Column(name = "CATEGORY_NAME")
    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    @OneToMany(targetEntity = Rewards.class,fetch = FetchType.LAZY, mappedBy = "Category_ID",orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<Rewards> getRewards() {
        return rewards;
    }

    public void setRewards(Set<Rewards> rewards) {
        this.rewards = rewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward_Category that = (Reward_Category) o;
        return Objects.equals(Category_ID, that.Category_ID) && Objects.equals(Category_Name, that.Category_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Category_ID, Category_Name);
    }

    @Override
    public String toString() {
        return "Reward_Category{" +
                "Category_ID=" + Category_ID +
                ", Category_Name=" + Category_Name +
                ", rewards=" + rewards +
                '}';
    }
}