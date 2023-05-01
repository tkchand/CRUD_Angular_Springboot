package com.crud.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "EMPLOYEES")
@NamedQuery(
	    name="findAllEmployee",
	    query="SELECT c FROM Employees c"
	)
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")	
	private Long id;
	
	@JsonProperty("empCode")
	@Column(name="EMPCODE")
	private String empCode;
	
	@JsonProperty("jobTitleName")
	@Column(name="JOBTITLENAME", nullable = true)
	private String jobTitleName;
	
	@JsonProperty("firstName")
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@JsonProperty("lastName")
	@Column(name="LASTNAME")
	private String lastName;
	
	@JsonProperty("emailId")
	@Column(name="EMAILID")
	private String emailId;
	
	@JsonProperty("phoneNumber")
	@Column(name="PHONENUMBER", nullable = true)
	private Integer phoneNumber;
	
	@JsonProperty("address1")
	@Column(name="ADDRESS1")
	private String address1;
	
	@JsonProperty("address2")
	@Column(name="ADDRESS2", nullable = true)
	private String address2;
	
	@JsonProperty("age")
	@Column(name="AGE", nullable = true)
	private Integer age;
	
	@JsonProperty("salary")
	@Column(name="SALARY", nullable = true )
	private Double salary;
	
}
