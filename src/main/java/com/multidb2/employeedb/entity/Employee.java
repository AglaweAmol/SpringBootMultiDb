package com.multidb2.employeedb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "emp_name")
	private String empName;


	@Column(name = "dept_name")
	private String deptName;

}
