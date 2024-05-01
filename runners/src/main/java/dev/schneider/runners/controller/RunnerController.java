package dev.schneider.runners.controller;

import dev.schneider.runners.model.Runner;
import dev.schneider.runners.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/runner")
public class RunnerController {

    @Autowired
    private RunnerService runnerService;

    @GetMapping("/getRunner")
    public ResponseEntity<List<Runner>> getAllRunner(){
        return new ResponseEntity<List<Runner>>(runnerService.allRunner(), HttpStatus.OK);
    }

    @PostMapping("/addRunner")
    public ResponseEntity<Runner> addRunner(@RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        String gender = (String) payload.get("gender");
        Integer age = (Integer) payload.get("age");


        Runner runner = runnerService.createRunner(name,gender, age);
        return new ResponseEntity<>(runner, HttpStatus.OK);
    }
}
