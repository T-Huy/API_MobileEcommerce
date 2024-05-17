package com.ecomerce.android.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "color")
public class Color implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "color_ID")
	private int colorId;

	@Column(name = "name", columnDefinition = "varchar(20)")
	private String name;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="update_at")
	private Timestamp updateAt;

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