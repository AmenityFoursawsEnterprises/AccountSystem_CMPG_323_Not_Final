package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Rewards;

import java.io.Serializable;
import java.util.Objects;
@ApiModel( value = "Rewards", description = "A DTO that represents the Rewards table.")
public class RewardsDto implements Serializable{

    private static final long serialVersionUID = -945781413063892297L;

    private String Reward_Name;
    private Long Miles_Count;
    private String Currency_Value;
    private String Description;
    private String Company;

    public RewardsDto() {
    }

    public RewardsDto(String reward_Name, Long miles_Count, String currency_Value, String description, String company) {
        Reward_Name = reward_Name;
        Miles_Count = miles_Count;
        Currency_Value = currency_Value;
        Description = description;
        Company = company;
    }
    public RewardsDto(Rewards rewards) {
        this.setCompany(rewards.getCompany());
        this.setCurrency_Value(rewards.getCurrency_Value());
        this.setDescription(rewards.getDescription());
        this.setReward_Name(rewards.getReward_Name());
        this.setMiles_Count(rewards.getMiles_Count());
    }
    //Remember to place @ApiModelProperty on all the getters = Nice clear code for client
    /*@ApiModelProperty(position = 1,
            value = "Rewards Name",
            name = "Name",
            notes = "Give a name to a specific reward.",
            dataType = "java.lang.String",
            example = "Hokey Stick",
            required = true
    )*/
    public String getReward_Name() {
        return Reward_Name;
    }

    public void setReward_Name(String reward_Name) {
        Reward_Name = reward_Name;
    }
    /*@ApiModelProperty(position = 2,
            value = "Rewards Miles",
            name = "Miles_Count",
            notes = "How many miles does this reward require.",
            dataType = "java.lang.Long",
            example = "500",
            allowEmptyValue = true
    )*/
    public Long getMiles_Count() {
        return Miles_Count;
    }

    public void setMiles_Count(Long miles_Count) {
        Miles_Count = miles_Count;
    }
    /* @ApiModelProperty(position = 3,
             value = "Rewards Currency Value",
             name = "Currency_Value",
             notes = "How much is this reward worth in real currency.",
             dataType = "java.lang.Long",
             example = "R500",
             required = false
     )*/
    public String getCurrency_Value() {
        return Currency_Value;
    }

    public void setCurrency_Value(String currency_Value) {
        Currency_Value = currency_Value;
    }
    /*@ApiModelProperty(position = 4,
            value = "Rewards Description",
            name = "Description",
            notes = "Describe the reward to the client.",
            dataType = "java.lang.Long",
            example = "Get a free Hokey stick.",
            allowEmptyValue = true
    )*/
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
    /*@ApiModelProperty(position = 5,
            value = "Rewards Company",
            name = "Company",
            notes = "Name of the company that offers the reward.",
            dataType = "java.lang.Long",
            example = "Mr Price Sports",
            required = false
    )*/
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
        RewardsDto that = (RewardsDto) o;
        return Objects.equals(Reward_Name, that.Reward_Name) && Objects.equals(Miles_Count, that.Miles_Count) && Objects.equals(Currency_Value, that.Currency_Value) && Objects.equals(Description, that.Description) && Objects.equals(Company, that.Company);
    }
    @JsonIgnore//This lets you hide certain parts of the AccountType for security purposes by not allowing DB entities to be exposed to the client
    public Rewards getRewards(){
        return new Rewards(getReward_Name(), getMiles_Count(), getCurrency_Value(), getDescription(),getCompany());
    }
    @Override
    public int hashCode() {
        return Objects.hash(Reward_Name, Miles_Count, Currency_Value, Description, Company);
    }

    @Override
    public String toString() {
        return "RewardsDto{" +
                "Reward_Name='" + Reward_Name + '\'' +
                ", Miles_Count=" + Miles_Count +
                ", Currency_Value=" + Currency_Value +
                ", Description=" + Description +
                ", Company=" + Company +
                '}';
    }
}
