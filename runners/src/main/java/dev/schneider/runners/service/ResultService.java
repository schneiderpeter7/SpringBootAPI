package dev.schneider.runners.service;

import dev.schneider.runners.dao.RaceRepository;
import dev.schneider.runners.dao.ResultRepository;
import dev.schneider.runners.dao.RunnerRepository;
import dev.schneider.runners.model.Race;
import dev.schneider.runners.model.Result;
import dev.schneider.runners.model.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private RunnerRepository runnerRepository;
    public List<Result> allResult()
    {

        return resultRepository.findAll();
    }
    public List<Object[]>raceRunner(Integer raceId){
    return resultRepository.findResultByRaceId(raceId);
    }
    public Result addResult(String runnerName,String raceName,Integer time){
        Runner runner= runnerRepository.findByName(runnerName);
        Race race= raceRepository.findRaceByRaceName(raceName);
        if (race!= null && runner!= null){
            Result result= new Result(runner,race,time);
             return resultRepository.save(result);
        }
        else {
            throw new RuntimeException("Hibás futónév");
        }
    }
    public Optional<Double> averageTime(Integer raceId){
        return resultRepository.findAverageTimeByRaceId(raceId);
    }
}
