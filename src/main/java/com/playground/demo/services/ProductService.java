package com.playground.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playground.demo.dto.ProductDTO;
import com.playground.demo.dto.ProductDepartmentDTO;
import com.playground.demo.entities.Department;
import com.playground.demo.entities.Product;
import com.playground.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<ProductDTO> findAll() {
		List<Product> result = repository.findAll();
		List<ProductDTO> dto = result.stream().map(x -> new ProductDTO(x)).toList();
		return dto;
	}		
	
	@Transactional
	public ProductDepartmentDTO insert (ProductDepartmentDTO dto) {		
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());		
		Department department = new Department();
		department.setId(dto.getDepartment().getId());
		entity.setDepartment(department);		
		entity = repository.save(entity);		
		return new ProductDepartmentDTO(entity);
	}
}