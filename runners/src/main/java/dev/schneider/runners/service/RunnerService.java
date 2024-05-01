package dev.schneider.runners.service;

import dev.schneider.runners.dao.RunnerRepository;
import dev.schneider.runners.model.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerService {

@Autowired
    private RunnerRepository runnerRepository;
    public List<Runner> allRunner(){
        return runnerRepository.findAll();
    }
   public Runner createRunner(String name,String gender, Integer age){

       Runner runner = new Runner();
       runner.setName(name);
       runner.setGender(gender);
       runner.setAge(age);

       return runnerRepository.save(runner);
   }
}
