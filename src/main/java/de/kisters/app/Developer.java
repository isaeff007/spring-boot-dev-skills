package de.kisters.app;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by ak on 25.01.2017.
 */
@Entity
@Getter
@Setter
@Table(name="developer")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEVELOPER_SEQUENCE")
    @SequenceGenerator(name="DEVELOPER_SEQUENCE", sequenceName = "DEVELOPER_SEQUENCE", allocationSize = 1)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToMany
    List<Skill> skills;
    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    public Developer(){
        super();
    }

    public Developer(String firstName, String lastName, String email,
        List<Skill> skills, Address address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skills = skills;
        this.address = address;
    }

    public boolean hasSkill(Skill skill){
        for (Skill containedSKill: getSkills()){
            if (containedSKill.getId()==skill.getId()){
                return true;
            }
        }
        return false;
    }
}
