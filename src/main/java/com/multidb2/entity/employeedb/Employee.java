package com.multidb2.entity.employeedb;

import javax.persistence.*;
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
