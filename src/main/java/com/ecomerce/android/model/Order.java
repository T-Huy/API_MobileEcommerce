package com.ecomerce.android.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_ID")
	private int orderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_name")
	private Customer customer;

	@Column(name="total_price")
	private double totalPrice;
	
	@Column(name="status")
	private Status status;
	
	@Column(name = "order_date")
    private Timestamp order_date;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="update_at")
	private Timestamp updateAt;
	
	
	@OneToMany(mappedBy="order", cascade = CascadeType.PERSIST)
	private List<Lineitem> lineitems;

	@PrePersist
	public void prePersist() {
		this.order_date = Timestamp.valueOf(LocalDateTime.now());
		this.createdAt = Timestamp.valueOf(LocalDateTime.now());
		this.updateAt = Timestamp.valueOf(LocalDateTime.now());
	}

	@PreUpdate
	public void preUpdate() {
		this.updateAt = Timestamp.valueOf(LocalDateTime.now());
	}
}