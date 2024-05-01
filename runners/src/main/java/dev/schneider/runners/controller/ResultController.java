package dev.schneider.runners.controller;

import dev.schneider.runners.model.Result;
import dev.schneider.runners.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/getResult")
    public ResponseEntity<List<Result>> getAllResult(){
        return new  ResponseEntity<List<Result>>(resultService.allResult(),HttpStatus.OK);
    }

    @GetMapping("/getRaceRunner/{raceId}")
    public ResponseEntity<List<Object[]>> getRaceRunner(@PathVariable Integer raceId){
        return new ResponseEntity<List<Object[]>>(resultService.raceRunner(raceId),HttpStatus.OK);
    }

    @PostMapping("/addResult")
    public ResponseEntity<Result> getAddResult(@RequestBody Map<String,Object> payload){
        String runnerName = (String) payload.get("runnerName");
        String raceName = (String) payload.get("raceName");
        Integer time = (Integer) payload.get("time");

        Result result = resultService.addResult(runnerName, raceName, time);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAverageTime/{raceId}")
    public ResponseEntity<Optional<Double>>getAverageTime(@PathVariable Integer raceId){
        return new ResponseEntity<Optional<Double>>(resultService.averageTime(raceId),HttpStatus.OK);
    }
}
