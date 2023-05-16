package com.jspiders.productapp.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="product")
public class ProductPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	private String name;
	
	private String brand;
	
	private double price;
	
	private int quantity;

}
