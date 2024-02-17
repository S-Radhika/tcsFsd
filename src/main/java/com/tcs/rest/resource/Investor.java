package com.tcs.rest.resource;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity


@Table(name= "investor")
public class Investor {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double amount;
	private String address;


}
