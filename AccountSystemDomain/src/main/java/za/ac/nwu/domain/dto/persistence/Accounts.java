package za.ac.nwu.domain.dto.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT")
public class Accounts implements Serializable {

    private Long account_ID;
    private Member member_ID;
    private Miles miles_ID;
    private Set <Rewards> reward_ID1;

    public Accounts() {
    }

    public Accounts(Long account_ID, Member member_ID, Miles miles_ID,Set <Rewards>  reward_ID1) {
        this.account_ID = account_ID;
        this.member_ID = member_ID;
        this.miles_ID = miles_ID;
        this.reward_ID1 = reward_ID1;
    }
    @Id
    @SequenceGenerator(name= "GENERATE_ACCOUNT_SEQ", sequenceName = "ACCOUNT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATE_ACCOUNT_SEQ")
    @Column(name = "ACCOUNT_ID")
    public Long getAccount_ID() {
        return account_ID;
    }

    public void setAccount_ID(Long account_ID) {
        this.account_ID = account_ID;
    }

    @OneToOne(targetEntity = Member.class, mappedBy = "Member_ID" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    public Member getMember_ID() {
        return member_ID;
    }

    public void setMember_ID(Member member_ID) {
        this.member_ID = member_ID;
    }

    @OneToOne(targetEntity = Miles.class, mappedBy = "miles_ID" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MILES_ID") /*this is not a name in the database, but a new colum that will be created*/

    @Column(name = "MILES_ID")
    public Miles getMiles_ID() {
        return miles_ID;
    }

    public void setMiles_ID(Miles miles_ID) {
        this.miles_ID = miles_ID;
    }

    @OneToMany(targetEntity = Rewards.class,fetch = FetchType.LAZY, mappedBy = "Reward_ID" /*orphanRemoval = true*/, cascade = CascadeType.PERSIST)
    @Column(name = "REWARD_ID1")
    public Set <Rewards>  getReward_ID1() {
        return reward_ID1;
    }

    public void setReward_ID1(Set <Rewards>  reward_ID1) {
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
