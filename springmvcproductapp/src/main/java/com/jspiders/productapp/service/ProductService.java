package com.jspiders.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.productapp.pojo.ProductPojo;
import com.jspiders.productapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public ProductPojo add(String name, String brand, double price, int quantity) {
		ProductPojo pojo=repository.add(name,brand,price,quantity);
		return pojo;
	}

	public ProductPojo remove(int id) {
		ProductPojo pojo=repository.remove(id);
		return pojo;
	}

	public List<ProductPojo> searchAll() {
		List<ProductPojo> pojo=repository.searchAll();		
		return pojo;
	}

	public ProductPojo search(int id) {
	   ProductPojo pojo=repository.search(id);
		return pojo;
	}

	public ProductPojo update(int id, String name, String brand, double price, int quantity) {
        ProductPojo pojo=repository.update(id,name,brand,price,quantity);
		return pojo;
        
		
	}

}
