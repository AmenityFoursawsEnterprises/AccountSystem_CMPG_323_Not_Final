package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MEMBER")
public class Member implements Serializable{

    private static final long serialVersionUID = 982996619435666458L;
    private Long Member_ID;
    private Long Member_Name;
    private Long Contact_No;

    public Member() {
    }

    public Member(Long member_ID, Long member_Name, Long contact_No) {
        Member_ID = member_ID;
        Member_Name = member_Name;
        Contact_No = contact_No;
    }

    @Id
    @SequenceGenerator(name= "GENERATE_MEMBER_SEQ", sequenceName = "ACCOUNT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATE_MEMBER_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMember_ID() {
        return Member_ID;
    }

    public void setMember_ID(Long member_ID) {
        Member_ID = member_ID;
    }
    @Column(name = "MEMBER_NAME")
    public Long getMember_Name() {
        return Member_Name;
    }

    public void setMember_Name(Long member_Name) {
        Member_Name = member_Name;
    }
    @Column(name = "CONTACT_NO")
    public Long getContact_No() {
        return Contact_No;
    }

    public void setContact_No(Long contact_No) {
        Contact_No = contact_No;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(Member_ID, member.Member_ID) && Objects.equals(Member_Name, member.Member_Name) && Objects.equals(Contact_No, member.Contact_No);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Member_ID, Member_Name, Contact_No);
    }

    @Override
    public String toString() {
        return "Member{" +
                "Member_ID=" + Member_ID +
                ", Member_Name=" + Member_Name +
                ", Contact_No=" + Contact_No +
                '}';
    }
}
