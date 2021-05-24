package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsDao extends JpaRepository<Product,String> {
}
