package com.ecomerce.android.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
	
	@Id
	@Column(name = "user_name", columnDefinition = "varchar(100)")
	private String userName;
	
	@Column(name = "fullname", columnDefinition = "varchar(200)")
	private String fullname;
	
	@Column(name = "address", columnDefinition = "varchar(200)")
	private String address;

	@Column(name = "phonenumber", columnDefinition = "varchar(11)")
    private String phoneNumber;

	@Column(name = "avatar", columnDefinition = "varchar(200)")
    private String avatar;

	@OneToOne()
	@JoinColumn(name="userName")
	private User user;

	@OneToMany(mappedBy="customer")
	private List<Order> orders;


	@OneToMany(mappedBy="customer")
	private List<Review> reviews;

	public Customer(String userName) {
		super();
		this.userName = userName;
	}
}