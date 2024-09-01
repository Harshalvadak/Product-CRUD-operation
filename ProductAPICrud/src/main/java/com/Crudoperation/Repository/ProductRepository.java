package com.Crudoperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Crudoperation.Model.Products;

import java.util.List;
import java.util.Optional;

public  interface ProductRepository extends JpaRepository<Products, Long> {

		

}
