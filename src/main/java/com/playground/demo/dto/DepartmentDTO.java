package com.playground.demo.dto;

import com.playground.demo.entities.Product;

public class DepartmentDTO {

	private Long id;
	private String name;
	
	public DepartmentDTO() {		
	}
	
	public DepartmentDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public DepartmentDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}	
}