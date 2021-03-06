package de.kisters.app;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ak on 26.01.2017.
 */
public  class InitData {

    @Autowired
    DeveloperRepository developerRepository;
    @Autowired
    SkillRepository skillRepository;

    public InitData(SkillRepository skillRepository, DeveloperRepository developerRepository) {
        this.skillRepository = skillRepository;
        this.developerRepository = developerRepository;
    }

    public void  fillData(){
        Skill javascript = new Skill("javascript","javascript language skill");
        Skill java = new Skill("java 8", "java 8 for BE");
        Skill angularjs = new Skill("AngularJS", "Angularjs Framework 2.0");
        Skill spring = new Skill ("Spring Boot", "CRUD Application");
        Skill osgi = new Skill("Osgi", "Server Bundle Framework");

        skillRepository.save(java);
        skillRepository.save(javascript);
        skillRepository.save(angularjs);
        skillRepository.save(spring);
        skillRepository.save(osgi);


        List<Developer> developers = new LinkedList<Developer>();
        developers.add(new Developer("John", "Smith", "john.smith@example.com",
            Arrays.asList(new Skill[] { javascript, angularjs }), new Address("Garden St.","13", "07039", "Livingston","USA")));
        developers.add(new Developer("Mark", "Johnson", "mjohnson@example.com",
            Arrays.asList(new Skill[] { javascript, angularjs }), new Address("Glenlake Avenue ","7920", "34786","Ankeny", "USA")));
        developers.add(new Developer("Michael", "Williams", "michael.williams@example.com",
            Arrays.asList(new Skill[] { angularjs, java }), new Address("Fairview Street","8547C ", "36532", "Fairhope", "USA")));
        developers.add(new Developer("Fred", "Miller", "f.miller@example.com",
            Arrays.asList(new Skill[] { spring, angularjs, javascript }), new Address("West Arch Drive","42", "07039", "Ontario","Canada")));
        developers.add(new Developer("Bob", "Brown", "brown@example.com",
            Arrays.asList(new Skill[] { osgi }), new Address("Bay Drive","85", "07039", "Vancouver","Canada")));
        developerRepository.save(developers);
    }
}
