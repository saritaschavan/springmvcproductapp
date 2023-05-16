package com.jspiders.productapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.productapp.pojo.ProductPojo;

@Repository
public class ProductRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpqlquery;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("product");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	private static void closeConnection() {
		
		if(factory !=null) {
			factory.close();
		}
		
		if(manager !=null) {
			manager.close();
		}
		
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}

	public ProductPojo add(String name, String brand, double price, int quantity) {
		openConnection();
		transaction.begin();
		ProductPojo pojo=new ProductPojo();
		pojo.setName(name);
		pojo.setBrand(brand);
		pojo.setPrice(price);
		pojo.setQuantity(quantity);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
				return pojo;
	}


	public List<ProductPojo> searchAll() {
		openConnection();
		transaction.begin();
		jpqlquery="from ProductPojo";
		query=manager.createQuery(jpqlquery);
		List<ProductPojo> pojo = query.getResultList();
		transaction.commit();
		closeConnection();
		return pojo;
		
	}

	public ProductPojo remove(int id) {
		openConnection();
		transaction.begin();
		ProductPojo pojo = manager.find(ProductPojo.class, id);
		manager.remove(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public ProductPojo search(int id) {
		openConnection();
		transaction.begin();
		ProductPojo pojo = manager.find(ProductPojo.class, id);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public ProductPojo update(int id, String name, String brand, double price, int quantity) {
		openConnection();
		transaction.begin();
		ProductPojo pojo = manager.find(ProductPojo.class, id);
		pojo.setName(name);
		pojo.setBrand(brand);
		pojo.setPrice(price);
		pojo.setQuantity(quantity);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

}
