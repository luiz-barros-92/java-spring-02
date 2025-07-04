package com.playground.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playground.demo.dto.CategoryDTO;
import com.playground.demo.dto.ProductDTO;
import com.playground.demo.entities.Category;
import com.playground.demo.entities.Department;
import com.playground.demo.entities.Product;
import com.playground.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> result = repository.findAll();
		List<ProductDTO> dto = result.stream().map(x -> new ProductDTO(x)).toList();
		return dto;
	}		
	
	@Transactional
	public ProductDTO insert (ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());		
		Department department = new Department();
		department.setId(dto.getDepartmentId());
		entity.setDepartment(department);
		for (CategoryDTO catDto : dto.getCategories()) {
			Category cat = new Category();
			cat.setId(catDto.getId());
			entity.getCategories().add(cat);
		}
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}
}