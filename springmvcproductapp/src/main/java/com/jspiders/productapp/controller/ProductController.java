package com.jspiders.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.productapp.pojo.ProductPojo;
import com.jspiders.productapp.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/home")
	public String home(ModelMap map) {

		List<ProductPojo> pojos = service.searchAll();
		map.addAttribute("pojos", pojos);

		return "Home";
	}

	@GetMapping("/welcome")
	public String come() {
		return "Home";
	}

	@GetMapping("/add")
	public String add() {
		return "Add";
	}

	@PostMapping("/add")
	public String addDetails(@RequestParam String name, @RequestParam String brand, @RequestParam double price,
			@RequestParam int quantity, ModelMap map) {
		ProductPojo pojo = service.add(name, brand, price, quantity);
		if (pojo != null) {
			map.addAttribute("pojo", pojo);
			map.addAttribute("msg", "product details inserted to the database..");
			List<ProductPojo> pojos = service.searchAll();
			map.addAttribute("pojos", pojos);
			return "Home";
		}
		map.addAttribute("msg", "Product details not inserted ...");
		List<ProductPojo> pojos = service.searchAll();
		map.addAttribute("pojos", pojos);
		return "Home";
	}

	@GetMapping("/remove")
	public String remove(ModelMap map) {
		List<ProductPojo> pojos = service.searchAll();
		map.addAttribute("pojos", pojos);
		return "Remove";
	}

	@PostMapping("/remove")
	public String removedetails(@RequestParam int id, ModelMap map) {
		ProductPojo pojo = service.remove(id);
		if (pojo != null) {
			map.addAttribute("msg", "product details remove..");
			List<ProductPojo> pojos = service.searchAll();
			map.addAttribute("pojos", pojos);
			return "Home";
		}
		map.addAttribute("msg", "product details not remove..");
		List<ProductPojo> pojos = service.searchAll();
		map.addAttribute("pojos", pojos);
		return "Home";
	}

	@GetMapping("/update")
	public String update(ModelMap map) {

		List<ProductPojo> pojos = service.searchAll();
		map.addAttribute("pojos", pojos);
		return "Edit";
	}

	@PostMapping("/update")
	public String update(@RequestParam int id, ModelMap map) {
		ProductPojo pojo = service.search(id);
		if (pojo != null) {
			map.addAttribute("pojo", pojo);
			return "Edit";
		}
		map.addAttribute("msg", "product details Not Found..");
		List<ProductPojo> pojos = service.searchAll();
		map.addAttribute("pojos", pojos);
		return "Edit";
	}

	@PostMapping("/updatedata")
	public String updateData(@RequestParam int id, @RequestParam String name, @RequestParam String brand,
			@RequestParam double price, @RequestParam int quantity, ModelMap map) {
		ProductPojo pojo = service.update(id, name, brand, price, quantity);
		if (pojo != null) {
			map.addAttribute("msg", "product details updated successfully..");
			List<ProductPojo> pojos = service.searchAll();
			map.addAttribute("pojos", pojos);
			return "Home";
		}
		map.addAttribute("msg", "product details not updated..");
		List<ProductPojo> pojos = service.searchAll();
		map.addAttribute("pojos", pojos);

		return "Home";
	}

}
