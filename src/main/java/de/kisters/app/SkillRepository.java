package de.kisters.app;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ak on 25.01.2017.
 */
public interface SkillRepository extends JpaRepository<Skill, Long> {
    public Skill findByLabel(String label);
}
