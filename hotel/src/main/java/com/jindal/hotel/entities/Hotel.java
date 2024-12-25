package com.jindal.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "hotels")
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

	@Id
	private String id;
	private String name;
	private String location;
	private String about;
}