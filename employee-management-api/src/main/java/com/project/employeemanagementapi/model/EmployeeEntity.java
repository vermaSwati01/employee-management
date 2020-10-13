package com.project.employeemanagementapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="TBL_EMPLOYEES")
public class EmployeeEntity implements Serializable{

   
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	@NotNull
    @Size(max = 65)
    @Column(name="first_name")
    private String firstName;
    
	@Size(max = 65)
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email", nullable=false, length=200)
    private String email;
    
	/*
	 * @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy =
	 * "EmployeeEntity") private AccountEntity accountEntity;
	 */
    
    public EmployeeEntity() {
		//super();
	}

    
  	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * public AccountEntity getAccountNumber() { return accountEntity; }
	 * 
	 * public void setAccountNumber(AccountEntity accountNumber) {
	 * this.accountEntity = accountNumber; }
	 */
	

		@Override
		public String toString() {
			return "EmployeeEntity [" +  ", firstName=" + firstName + ", lastName=" + lastName + ", email="
					+ email + "]";
		}

  
}