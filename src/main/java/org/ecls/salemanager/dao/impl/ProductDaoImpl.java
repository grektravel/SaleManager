package org.ecls.salemanager.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.ecls.salemanager.dao.ProductDao;
import org.ecls.salemanager.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory session;
	@Override
	public void add(Product product) {
		session.getCurrentSession().save(product);

	}

	@Override
	public void save(Product product) {
		session.getCurrentSession().merge(product);

	}

	@Override
	public void delete(int idProduct) {
		session.getCurrentSession().delete(getProduct(idProduct));

	}

	@Override
	public Product getProduct(int idProduct) {
		return (Product)session.getCurrentSession().get(Product.class, idProduct);
	}

	@Override
	public List getAllProduct() {
		return session.getCurrentSession().createCriteria(Product.class).list();
	}

}
