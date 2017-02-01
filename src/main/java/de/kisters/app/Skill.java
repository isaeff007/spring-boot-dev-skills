package de.kisters.app;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by ak on 25.01.2017.
 */
@Getter
@Setter
@Entity
@Table(schema="akjpademo", name="skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SKILL_SEQUENCE")
    @SequenceGenerator(name="SKILL_SEQUENCE", sequenceName = "SKILL_SEQUENCE", allocationSize = 1)
    private long id;
    private String label;
    private String description;

    public Skill(){
        super();
    }

    public Skill(String label, String description){
        super();
        this.label = label;
        this.description=description;
    }

}
