package de.kisters.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcappApplication implements CommandLineRunner {

	@Autowired
	DeveloperRepository developerRepository;
	@Autowired
    SkillRepository skillRepository;


	public static void main(String[] args)
	{

		SpringApplication.run(MvcappApplication.class, args);
	}

    @Override public void run(String... strings) throws Exception {
        InitData initData = new InitData(skillRepository, developerRepository );
        initData.fillData();

    }
}
