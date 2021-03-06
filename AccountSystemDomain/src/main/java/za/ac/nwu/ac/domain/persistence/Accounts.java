//Accounts Persistence
package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNTS", schema = "HR")
public class Accounts implements Serializable {

    private static final long serialVersionUID = -4423761815898190602L;


    private Long account_ID;
    private Member member_ID;
    private Miles miles_ID;
    private /*Set <Rewards> */ Rewards reward_ID1;

    public Accounts() {
    }

    public Accounts(Long account_ID, Member member_ID, Miles miles_ID,/*Set <Rewards>*/ Rewards reward_ID1) {
        this.account_ID = account_ID;
        this.member_ID = member_ID;
        this.miles_ID = miles_ID;
        this.reward_ID1 = reward_ID1;
    }
    @Id
    @SequenceGenerator(name= "DEMO_GENERIC_SEQ", sequenceName = "HR.DEMO_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_GENERIC_SEQ")
    @Column(name = "ACCOUNT_ID")
    public Long getAccount_ID() {
        return account_ID;
    }

    public void setAccount_ID(Long account_ID) {
        this.account_ID = account_ID;
    }

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "Member_ID")
    public Member getMember_ID() {
        return member_ID;
    }

    public void setMember_ID(Member member_ID) {
        this.member_ID = member_ID;
    }

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "MILES_ID", referencedColumnName = "miles_ID") /*this is not a name in the database, but a new column that will be created*/
/*
    @Column(name = "MILES_ID")*/
    public Miles getMiles_ID() {
        return miles_ID;
    }

    public void setMiles_ID(Miles miles_ID) {
        this.miles_ID = miles_ID;
    }

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REWARD_ID1")*/
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "REWARD_ID", referencedColumnName = "Reward_ID")
    public /*Set <Rewards>*/Rewards getReward_ID1() {
        return reward_ID1;
    }

    public void setReward_ID1(/*Set <Rewards>*/Rewards reward_ID1) {
        this.reward_ID1 = reward_ID1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Objects.equals(account_ID, accounts.account_ID) && Objects.equals(member_ID, accounts.member_ID) && Objects.equals(miles_ID, accounts.miles_ID) && Objects.equals(reward_ID1, accounts.reward_ID1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_ID, member_ID, miles_ID, reward_ID1);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "account_ID=" + account_ID +
                ", member_ID=" + member_ID +
                ", miles_ID=" + miles_ID +
                ", reward_ID1=" + reward_ID1 +
                '}';
    }
}
