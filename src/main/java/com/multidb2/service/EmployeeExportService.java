package com.multidb2.service;


import com.multidb2.entity.employeedb.Employee;
import com.multidb2.repository.employeedb.EmployeeRepository;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeExportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void exportEmployeesToCSV(String filePath) throws IOException {
        File file = new File(filePath);
        // Ensure directory exists
        file.getParentFile().mkdirs();

        List<Employee> employees = employeeRepository.findAll();

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write CSV header
//            writer.writeNext(new String[]{"ID", "Employee Name", "Department Name"});

            // Write employee data
            for (Employee employee : employees) {
                writer.writeNext(new String[]{
                        String.valueOf(employee.getId()),
                        employee.getEmpName(),
                        employee.getDeptName()
                });
            }
        }


    }}
