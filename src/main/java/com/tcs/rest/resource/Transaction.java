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


@Table(name= "transaction")
public class Transaction{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;
	private double tamount;
	private int  iid;


}
