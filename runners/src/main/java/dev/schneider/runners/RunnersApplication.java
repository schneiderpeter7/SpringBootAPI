package dev.schneider.runners;

import dev.schneider.runners.dao.RaceRepository;
import dev.schneider.runners.dao.ResultRepository;
import dev.schneider.runners.dao.RunnerRepository;
import dev.schneider.runners.model.Race;
import dev.schneider.runners.model.Result;
import dev.schneider.runners.model.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@Component
public class RunnersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
	}

	@Autowired
	private RunnerRepository runnerRepository;
	@Autowired
	private RaceRepository raceRepository;
	@Autowired
	private ResultRepository resultRepository;

	@Override
	public void run(String... args) throws Exception {
		// Alapadatok inicializálása
		Runner runner1 = new Runner("John Doe", "male", 30);
		Runner runner2 = new Runner("Jane Smith", "female", 25);
		Runner runner3 = new Runner("Peter Smith", "male", 18);
		Runner runner4 = new Runner("Jazmin Kovacs", "male", 36);
		Runner runner5 = new Runner("Simeon Szabó", "male", 19);
		Runner runner6 = new Runner("Thomas Kroos", "male", 20);
		Runner runner7 = new Runner("Kristof Nagy", "male", 25);
		Runner runner8 = new Runner("Lili Szegedi", "female", 16);

		Race race1= new Race("BalatonGo",10);
		Race race2= new Race("VelenceGo",5);
		Race race3= new Race("GyörGo",15);
		Race race4= new Race("BudapestGo",20);
		Race race5= new Race("DebrecenGo",17);

		Result result1= new Result(runner1,race2,50);
		Result result2= new Result(runner1,race1,30);
		Result result3= new Result(runner3,race1,54);
		Result result4= new Result(runner2,race2,23);
		Result result5= new Result(runner3,race2,42);
		Result result6= new Result(runner6,race1,59);
		Result result7= new Result(runner3,race3,21);
		Result result8= new Result(runner7,race3,32);
		Result result9= new Result(runner8,race4,43);
		Result result10= new Result(runner5,race4,54);
		Result result11= new Result(runner6,race5,122);
		Result result12= new Result(runner6,race5,231);
		Result result13= new Result(runner5,race3,231);
		Result result14= new Result(runner7,race4,23);
		Result result15= new Result(runner8,race5,45);

		// Mentés az adatbázisba
		runnerRepository.saveAll(Arrays.asList(runner1, runner2,runner3, runner4,runner5,runner6,runner7,runner8));
		raceRepository.saveAll(Arrays.asList(race1,race2,race3,race4,race5));
		resultRepository.saveAll(Arrays.asList(result1,result2,result3,result4,result5,result6,result7,result8,result9,result10,result11,result12,result13,result14,result15));
	}

}
