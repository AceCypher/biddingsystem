package com.obs.pojos;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name="customer_id")
	private Integer id;

	@Column(name="user_name", length = 100)
	@NotEmpty(message="Name must not be blank")
	@Size(min = 3, message = "Username must be at least 3 characters!")
	private String name;

	@Column(name="user_email", length = 100)
	@NotEmpty(message="Email must not be blank")
	@Email(message="Invalid Email")
	@Size(min = 3, message = "User Email must be at least 3 characters!")
	private String email;

	@Column(name="user_password", length = 100)
	@NotEmpty(message="Password must be supplied")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Blank or Invalid Password")
	@Size(max=20, message="User password must not exceed to 20 characters.")
	private String password;
	
	private boolean enabled;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_date")
	private Date regDate;
	
//	@OneToOne(mappedBy="customer", cascade = CascadeType.ALL)
//    private Bid bid;
	
	public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
	
	public Customer() {
		System.out.println("in cust constr");
	}

	public Customer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//	public Bid getBid() {
//		return bid;
//	}
//
//	public void setBid(Bid bid) {
//		this.bid = bid;
//	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password +  "]";
	}

}
