package com.botsCrew;

import com.botsCrew.models.Degree;
import com.botsCrew.models.Department;
import com.botsCrew.models.Lector;
import com.botsCrew.repositories.DepartmentRepository;
import com.botsCrew.repositories.LectorRepository;
import com.botsCrew.services.DepartmentServiceImpl;
import com.botsCrew.services.LectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.botsCrew.services"})
@EnableAutoConfiguration
public class BotsCrewApplication implements CommandLineRunner {

	@Autowired
	private final DepartmentServiceImpl departmentService;

	@Autowired
	private final LectorServiceImpl lectorService;

	@Autowired
	LectorRepository lectorRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public BotsCrewApplication(DepartmentServiceImpl departmentService, LectorServiceImpl lectorService) {
		this.departmentService = departmentService;
		this.lectorService = lectorService;
	}


	public static void main(String[] args) {
		SpringApplication.run(BotsCrewApplication.class, args);
	}

	@Override
	public void run(String... args) {
		fillDb();
		showMenu();
	}

	public void showMenu() {
		String menu = "1.Head of department\n" +
				"2.Department statistic\n" +
				"3.Average salary\n" +
				"4.Count of employees\n" +
				"5.Global search\n" +
				"0.Exit\n" +
				"Type 1-5:";
		System.out.print(menu);
		String departmentName;
		Scanner scanner = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		int answer = scanner.nextInt();
		String typeName = "Type department name:";

		switch (answer) {
			case 1:
				System.out.print(typeName);
				departmentName = in.nextLine();
				System.out.println(departmentService.findHeadOfDepartment(departmentName));
				showMenu();
				break;
			case 2:
				System.out.print(typeName);
				departmentName = in.nextLine();
				departmentService.showDepartmentStatistics(departmentName);
				showMenu();
				break;
			case 3:
				System.out.print(typeName);
				departmentName = in.nextLine();
				System.out.print("Average salary for department: ");
				System.out.println(departmentService.showAverageSalaryForDepartment(departmentName));
				showMenu();
				break;
			case 4:
				System.out.print(typeName);
				departmentName = in.nextLine();
				departmentService.showCountOfEmployees(departmentName);
				showMenu();
				break;
			case 5:
				System.out.print("Global search: ");
				departmentName = in.nextLine();
				departmentService.findByTemplate(departmentName);
				showMenu();
				break;
			case 0:
				return;
			default:
				showMenu();
		}
	}

	public void fillDb() {
		lectorRepository.deleteAllInBatch();
		departmentRepository.deleteAllInBatch();

		Lector michele = new Lector("Michele", Degree.ASSOCIATE_PROFESSOR, 3000);
		Lector antony = new Lector("Antony", Degree.PROFESSOR, 5000);
		Lector ivan = new Lector("Ivan", Degree.ASSISTANT, 2000);
		Lector lara = new Lector("Lara", Degree.ASSISTANT, 2000);
		Lector george = new Lector("George", Degree.ASSOCIATE_PROFESSOR, 3100);
		Lector roman = new Lector("Roman", Degree.PROFESSOR, 5570);
		Lector josh = new Lector("Josh", Degree.ASSISTANT, 2000);

		Department department = new Department("Department1", antony);
		Department department1 = new Department("Department2", roman);
		Department department2 = new Department("Department3", george);
		departmentService.save(department);
		departmentService.save(department1);
		departmentService.save(department2);
		lectorService.saveAllLectors(Arrays.asList(antony, michele, josh, ivan, lara, george));
		department.getLectors().addAll(Arrays.asList(antony, michele, josh));
		department1.getLectors().addAll(Arrays.asList(ivan, michele, lara));
		department2.getLectors().addAll(Arrays.asList(george, ivan, josh));
		departmentService.save(department);
		departmentService.save(department1);
		departmentService.save(department2);
	}
}