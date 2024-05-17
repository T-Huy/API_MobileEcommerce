package com.ecomerce.android.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="options")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "options_ID")
	private int optionId;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_ID")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_ID")
    private Color color;
	
    @Column(name = "ram", columnDefinition = "varchar(100)")
	private String ram;

    @Column(name = "rom", columnDefinition = "varchar(100)")
	private String rom;

	@Column(name = "price")
	private double price;

	@Column(name = "status")
	private int status;

	@OneToMany(mappedBy="option")
	private List<Image> images;
}