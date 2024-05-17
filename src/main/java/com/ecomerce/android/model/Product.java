package com.ecomerce.android.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.annotations.SerializedName;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_ID")
	private int productId;

	@Column(name="product_name", columnDefinition = "varchar(50)")
	private String productName;
	
	@Column(name = "os", columnDefinition = "varchar(20)")
    private String os;
	
	@Column(name = "cpu", columnDefinition = "varchar(100)")
    private String cpu;

	@Column(name = "origin", columnDefinition = "varchar(200)")
    private String origin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="brandId")
	private Brand brand;
	
	@Column(name = "description", columnDefinition = "varchar(4000)")
	private String description;
	
	@Column(name = "battery", columnDefinition = "varchar(50)")
    private String battery;
	
	@Column(name = "screen", columnDefinition = "varchar(20)")
    private String screen;
	
	@Column(name = "price")
    private double price;
	
	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="update_at")
	private Timestamp updateAt;

	@OneToMany(mappedBy="product", fetch = FetchType.LAZY)
	private List<Option> options;

	@PrePersist
	public void prePersist() {
		this.createdAt = Timestamp.valueOf(LocalDateTime.now());
		this.updateAt = Timestamp.valueOf(LocalDateTime.now());
	}

	@PreUpdate
	public void preUpdate() {
		this.updateAt = Timestamp.valueOf(LocalDateTime.now());
	}
}