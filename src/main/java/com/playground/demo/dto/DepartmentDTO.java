package com.playground.demo.dto;

public class DepartmentDTO {

	private Long id;
	private String name;
	
	public DepartmentDTO() {		
	}
	
	public DepartmentDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}	
}