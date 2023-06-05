package com.security.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_details")
public class User {
	@Id
	@GeneratedValue
	private Integer id ;
	private String name ;
	private String email ;
	private String pwd ;
	@ElementCollection
	@CollectionTable(name="role_details",
		joinColumns = @JoinColumn(name="id"))
	@Column(name="role")
	private Set<String> roles ;
}
