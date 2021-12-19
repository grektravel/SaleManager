package org.ecls.salemanager.dao;

import java.util.List;

import org.ecls.salemanager.model.Product;

public interface ProductDao {
	
	public void add(Product product);
	public void save(Product product);
	public void delete(int idProduct);
	public Product getProduct(int idProduct);
	public List getAllProduct();	

}
