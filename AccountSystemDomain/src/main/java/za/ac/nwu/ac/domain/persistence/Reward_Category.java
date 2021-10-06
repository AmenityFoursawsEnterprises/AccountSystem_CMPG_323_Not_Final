package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "REWARD_CATEGORIES", schema = "HR")
public class Reward_Category implements Serializable{
    private static final long serialVersionUID = -7922155801441221111L;
    private Long Category_ID;
    private String Category_Name;
    private Rewards rewards;

    public Reward_Category() {
    }

    /*public Reward_Category(Long category_ID, String category_Name) {
        Category_ID = category_ID;
        Category_Name = category_Name;
    }*/

    public Reward_Category(Long category_ID, String category_Name, Rewards rewards) {
        Category_ID = category_ID;
        Category_Name = category_Name;
        this.rewards = rewards;
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

    @ManyToOne(fetch = FetchType.LAZY)//Where possible use lazy loading especially with linked tables. Lazy fetch only fetches the data when needed.
    @JoinColumn(name = "REWARD_ID")
    public Rewards getRewards() {
        return rewards;
    }

    public void setRewards(Rewards rewards) {
        this.rewards = rewards;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward_Category that = (Reward_Category) o;
        return Objects.equals(Category_ID, that.Category_ID) && Objects.equals(Category_Name, that.Category_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Category_ID, Category_Name);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward_Category that = (Reward_Category) o;
        return Objects.equals(Category_ID, that.Category_ID) && Objects.equals(Category_Name, that.Category_Name) && Objects.equals(rewards, that.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Category_ID, Category_Name, rewards);
    }

    /*@Override
    public String toString() {
        return "Reward_Category{" +
                "Category_ID=" + Category_ID +
                ", Category_Name=" + Category_Name +
                ", rewards=" + rewards +
                '}';
    }*/

    @Override
    public String toString() {
        return "Reward_Category{" +
                "Category_ID=" + Category_ID +
                ", Category_Name='" + Category_Name + '\'' +
                ", rewards=" + rewards +
                '}';
    }
}
