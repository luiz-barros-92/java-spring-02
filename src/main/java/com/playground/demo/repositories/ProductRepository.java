package com.playground.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.playground.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
