package com.edupeep.eduapis.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Column(name = "first_name", nullable = false)
    private String firstName;
	@Column(name = "last_name", nullable = false)
    private String lastName;
	@Column(name = "email_address", nullable = false)
    private String emailId;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "add_id", nullable = false)
    private String add_id;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "emergancy_ph", nullable = false)
    private String emergancy_ph;
    @Column(name = "activeLink", nullable = false)
    private String activeLink;
    @Column(name = "profile_pic", nullable = false)
    private String profile_pic;
    @Column(name = "status", nullable = false)
    private String status;
   
       
    public Employee() {
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="emp_id")
    private Set<Address> address;
   
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
   
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getPhone() {
		return phone;
	}
	
	
	public String getAdd_id() {
		return add_id;
	}
	public void setAdd_id(String add_id) {
		this.add_id = add_id;
	}
	
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmergancy_ph() {
		return emergancy_ph;
	}
	public void setEmergancy_ph(String emergancy_ph) {
		this.emergancy_ph = emergancy_ph;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getActiveLink() {
		return activeLink;
	}
	public void setActiveLink(String activeLink) {
		this.activeLink = activeLink;
	}
	
	public String getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", password=" + password + ", address=" + add_id + ", phone=" + phone + ", emergancy_ph="
				+ emergancy_ph + ", status=" + status + "]";
	}
	
    
}
