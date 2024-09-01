package com.Crudoperation.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Crudoperation.Model.Products;
import com.Crudoperation.Repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/product")
	public ResponseEntity<List<Products>> getAllproduct(){
		List<Products> proList = new ArrayList<>();
		productRepository.findAll().forEach(proList::add);
		return new ResponseEntity<List<Products>>(proList, HttpStatus.OK);
	}
	
	@PostMapping("/product")
	public String createNewproduct(@RequestBody Products product) {
		productRepository.save(product);
		return "Product  Created in database";
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Products> getProductsById(@PathVariable long id) {
		Optional<Products> pro = productRepository.findById(id);
		if (pro.isPresent()) {
			return new ResponseEntity<Products>(pro.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteEmployeeByEmpId(@PathVariable int id) {
		productRepository.deleteById((long) id);
		return "Product Deleted Successfully";
	}
	
	@PutMapping("/product/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable long id, @RequestBody Products product) {
        Optional<Products> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Products updatedProduct = existingProduct.get();
            updatedProduct.setProductName(product.getProductName());
            updatedProduct.setPrice(product.getPrice());
            productRepository.save(updatedProduct);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	

}
