package com.multidb2.controller;



import com.multidb2.service.EmployeeExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private EmployeeExportService employeeExportService;

    @GetMapping("/employees")
    public String exportEmployees() {
        try {
            // Adjust the file path as needed for your local system
            String filePath = "H:\\employees.csv";
            employeeExportService.exportEmployeesToCSV(filePath);
            return "CSV file created successfully at " + filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while creating CSV file.";
        }
    }


}
