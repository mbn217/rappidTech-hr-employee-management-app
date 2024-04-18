package org.example.model.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity
@Table(name = "employees")
public class Employees {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hire_date")
    private Date hire_date;

//    @ManyToOne
//    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
//    //@Column(name = "job_id")
//    private String job_id;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", nullable = true)
    private Jobs job;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "commission_pct")
    private Integer commission_pct;

//    @Column(name = "manager_id")
//    private Integer manager_id;
//
//    @Column(name = "department_id")
//    private Integer department_id;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;



}
