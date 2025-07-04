package com.playground.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.playground.demo.entities.Category;
import com.playground.demo.entities.Product;

public class ProductDTO {
	
	private Long id;
	private String name;
	private Double price;
	private Long departmentId;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, Double price, Long departmentId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.departmentId = departmentId;
	}
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		departmentId = entity.getDepartment().getId();
		for (Category cat : entity.getCategories()) {
			categories.add(new CategoryDTO(cat));
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}	
}