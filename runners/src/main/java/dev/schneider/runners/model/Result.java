package dev.schneider.runners.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "runnerId", referencedColumnName = "id")
    private Runner runner;

    @ManyToOne
    @JoinColumn(name = "raceId", referencedColumnName = "id")
    private Race race;

    private int time;
    public Result(Runner runner, Race race, int time) {
        this.runner = runner;
        this.race = race;
        this.time = time;
    }
}
