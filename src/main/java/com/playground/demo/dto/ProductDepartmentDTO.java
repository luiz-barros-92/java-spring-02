package com.playground.demo.dto;

public class ProductDepartmentDTO {

	private Long id;
	private String name;
	private Double price;
	
	private DepartmentDTO department;

	public ProductDepartmentDTO(Long id, String name, Double price, DepartmentDTO department) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.department = department;
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

	public DepartmentDTO getDepartment() {
		return department;
	}	
}