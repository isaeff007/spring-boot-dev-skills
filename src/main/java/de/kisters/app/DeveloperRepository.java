package de.kisters.app;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ak on 25.01.2017.
 */
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    List<Developer> findByFirstName(String firstname);
}
