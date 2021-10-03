package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "REWARDS", schema = "HR")
public class Rewards implements Serializable {

    private static final long serialVersionUID = -7874894918770821898L;

    private Long Reward_ID;
    /*Category_ID is a foreign key to Rewards_Category*/
    private Reward_Category Category_ID;
    private String Reward_Name;
    private Long Miles_Count;
    private String Currency_Value;
    private String Description;
    private String Company;

    public Rewards() {
    }

    public Rewards(Long reward_ID, Reward_Category category_ID, String reward_Name, Long miles_Count, String currency_Value, String description, String company) {
        Reward_ID = reward_ID;
        Category_ID = category_ID;
        Reward_Name = reward_Name;
        Miles_Count = miles_Count;
        Currency_Value = currency_Value;
        Description = description;
        Company = company;
    }

    public Rewards(String reward_Name, Long miles_Count, String currency_Value, String description, String company) {
        Reward_Name = reward_Name;
        Miles_Count = miles_Count;
        Currency_Value = currency_Value;
        Description = description;
        Company = company;
    }

    @Id
    @SequenceGenerator(name= "DEMO_GENERIC_SEQ", sequenceName = "HR.DEMO_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_GENERIC_SEQ")

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REWARD_ID")
    public Long getReward_ID() {
        return Reward_ID;
    }

    public void setReward_ID(Long reward_ID) {
        Reward_ID = reward_ID;
    }

    /*JoinColumn moet hierso staan, maar ek is nie seker nie*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    public Reward_Category getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(Reward_Category category_ID) {
        Category_ID = category_ID;
    }

    @Column(name = "REWARD_NAME")
    public String getReward_Name() {
        return Reward_Name;
    }

    public void setReward_Name(String reward_Name) {
        Reward_Name = reward_Name;
    }
    @Column(name = "MILES_COUNT")
    public Long getMiles_Count() {
        return Miles_Count;
    }

    public void setMiles_Count(Long miles_Count) {
        Miles_Count = miles_Count;
    }

    @Column(name = "CURRENCY_VALUE")
    public String getCurrency_Value() {
        return Currency_Value;
    }

    public void setCurrency_Value(String currency_Value) {
        Currency_Value = currency_Value;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Column(name = "COMPANY")
    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return Objects.equals(Reward_ID, rewards.Reward_ID) && Objects.equals(Category_ID, rewards.Category_ID) && Objects.equals(Reward_Name, rewards.Reward_Name) && Objects.equals(Miles_Count, rewards.Miles_Count) && Objects.equals(Currency_Value, rewards.Currency_Value) && Objects.equals(Description, rewards.Description) && Objects.equals(Company, rewards.Company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Reward_ID, Category_ID, Reward_Name, Miles_Count, Currency_Value, Description, Company);
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "Reward_ID=" + Reward_ID +
                ", Category_ID=" + Category_ID +
                ", Reward_Name=" + Reward_Name +
                ", Miles_Count=" + Miles_Count +
                ", Currency_Value=" + Currency_Value +
                ", Description=" + Description +
                ", Company=" + Company +
                '}';
    }
}
