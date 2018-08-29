//ProductServiceImp
package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.ProductService;

import demo.project.tables.model.Products;


@Component
@Transactional
public class ProductServiceImp implements ProductService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Products products;
	
	@Override
	public boolean addProducts(Products products) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().save(products);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean deleteProducts(Products products) {
		try
		{
			sessionFactory.getCurrentSession().delete(products);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	
}
