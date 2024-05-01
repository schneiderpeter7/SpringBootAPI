package dev.schneider.runners.dao;

import dev.schneider.runners.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {
    Optional<Race> findById(Integer id);
    Race findRaceByRaceName(String raceName);
}
