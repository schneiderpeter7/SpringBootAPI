package dev.schneider.runners.dao;

import dev.schneider.runners.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result,Integer> {
    @Query("SELECT r.runner.name, r.time FROM Result r WHERE r.race.id = :raceId ORDER BY r.time ASC")
    List<Object[]>findResultByRaceId(@Param("raceId") int raceId);
    @Query("SELECT AVG(r.time) AS average_time FROM Result r WHERE r.race.id = :raceId")
    Optional<Double> findAverageTimeByRaceId(@Param("raceId") int raceId);
}
