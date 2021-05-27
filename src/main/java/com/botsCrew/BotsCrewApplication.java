package com.botsCrew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotsCrewApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(BotsCrewApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BotsCrewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.print("1.Head of department\n" +
				"2.Department statistic\n" +
				"3.Average salary\n" +
				"Count of employees\n" +
				"5.Global search\n" +
				"Type 1-5:");
	}
}
