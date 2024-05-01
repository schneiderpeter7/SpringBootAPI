package dev.schneider.runners.service;

import dev.schneider.runners.dao.RaceRepository;
import dev.schneider.runners.model.Race;
import dev.schneider.runners.model.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;
    public ModelAndView allRace() {
        ModelAndView mav= new ModelAndView("list-raceAll");
        List<Race> races= raceRepository.findAll();
        mav.addObject("race",races);
        return mav;
    }
    public Optional<Race> getupdateRace(Integer id, String raceName, Integer distance) {
        Optional<Race> optionalRace = raceRepository.findById(id);
        if (optionalRace.isPresent()) {
            Race race = optionalRace.get();
            race.setRaceName(raceName);
            race.setDistance(distance);
            return Optional.of(raceRepository.save(race));
        } else {
            return Optional.empty();
        }
    }
}
