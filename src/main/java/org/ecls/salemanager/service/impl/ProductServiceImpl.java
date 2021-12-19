package org.ecls.salemanager.service.impl;

import java.util.List;

import org.ecls.salemanager.dao.ProductDao;
import org.ecls.salemanager.model.Product;
import org.ecls.salemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public void add(Product product) {
		productDao.add(product);

	}

	@Transactional
	public void save(Product product) {
		productDao.save(product);

	}

	@Transactional
	public void delete(int idProduct) {
		productDao.delete(idProduct);

	}

	@Transactional
	public Product getProduct(int idProduct) {
		return productDao.getProduct(idProduct);
	}

	@Transactional
	public List getAllProduct() {
		return productDao.getAllProduct();
	}

}
