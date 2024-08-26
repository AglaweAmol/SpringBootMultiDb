package com.multidb2.entity.countrydb;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "country")
@Data
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String countryName;

	private String countryCode;

}
