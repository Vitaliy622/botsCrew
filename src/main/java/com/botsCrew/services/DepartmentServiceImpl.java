package com.botsCrew.services;

import com.botsCrew.models.Degree;
import com.botsCrew.models.Department;
import com.botsCrew.models.Lector;
import com.botsCrew.repositories.DepartmentRepository;
import com.botsCrew.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl {

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Autowired
    private final LectorRepository lectorRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, LectorRepository lectorRepository) {
        this.departmentRepository = departmentRepository;
        this.lectorRepository = lectorRepository;
    }

    public String findHeadOfDepartment(String departmentName) {
        List<Department> departmentList = departmentRepository.findAll();

        for (Department n : departmentList) {
            if (n.getName().equals(departmentName)) {
                return n.getHeadOfDepartment().getName();
            }
        }
        return "Not found";
    }

    public void showDepartmentStatistics(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        long assistant = 0;
        long associateProfessor = 0;
        long professor = 0;
        List<Lector> lectors = department.getLectors();
        for (Lector lector : lectors) {
            if (lector.getDegree() == Degree.ASSISTANT) {
                assistant++;
            }
            if (lector.getDegree() == Degree.ASSOCIATE_PROFESSOR) {
                associateProfessor++;
            }
            if (lector.getDegree() == Degree.PROFESSOR) {
                professor++;
            }
        }
        String answer = "Assistants:" + assistant + "\nAssociate Professor:" + associateProfessor + "\nProfessor: " + professor;
        System.out.println(answer);
    }

    public long showAverageSalaryForDepartment(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        List<Lector> lectors = department.getLectors();

        int average;
        average = 0;
        for (Lector d : lectors) {
            average += d.getSalary();
        }
        return average / (lectors.size());
    }

    public void showCountOfEmployees(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        List<Lector> lectors = department.getLectors();
        System.out.println(lectors.size());
    }

    public void findByTemplate(String name) {
        List<Lector> lectors = lectorRepository.findByNameContaining(name);
        System.out.println(lectors);
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }
}
