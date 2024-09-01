package com.Crudoperation.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@Column(name = "ProductName")
	private String ProductName;
	
	@Column(name = "Price")
	private int Price;

	public  long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Products(long iD, String productName, int price) {
		super();
		ID = iD;
		ProductName = productName;
		Price = price;
	}
	
	public Products()
	{
		
	}

	@Override
	public String toString() {
		return "Products [ID=" + ID + ", ProductName=" + ProductName + ", Price=" + Price + "]";
	}
	
	
	
}

