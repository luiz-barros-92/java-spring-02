package com.playground.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.playground.demo.dto.ProductDTO;
import com.playground.demo.dto.ProductDepartmentDTO;
import com.playground.demo.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
		@Autowired
		private ProductService service;

		@GetMapping
		public List<ProductDTO> findAll() {
			List<ProductDTO> list = service.findAll();			
			return list;
		}
		
		@PostMapping
		public ResponseEntity<ProductDepartmentDTO> insert(@RequestBody ProductDepartmentDTO dto) {
			dto = service.insert(dto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
		}
}
