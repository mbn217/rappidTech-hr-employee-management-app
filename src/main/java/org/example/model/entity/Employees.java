package org.example.model.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employee_id;

    @Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

//    @Column(name = "hire_date")
//    @Temporal(TemporalType.DATE)
//    private Date hire_date;

//    @Column(name = "job_id")
//    private int job_id;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "commission_pct")
    private Integer commission_pct;

    @Column(name = "manager_id")
    private Integer manager_id;

    @Column(name = "department_id")
    private Integer department_id;



}
