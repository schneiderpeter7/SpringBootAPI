package dev.schneider.runners.dao;

import dev.schneider.runners.model.Runner;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Integer> {
    Runner findByName(String runnerName);
}
