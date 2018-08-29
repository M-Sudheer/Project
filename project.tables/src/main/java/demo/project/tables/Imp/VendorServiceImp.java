//VendorServiceImp
package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.VendorService;
import demo.project.tables.model.Vendor;


@Component
@Transactional
public class VendorServiceImp implements VendorService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addVendor(Vendor vendor)
	
	{
		try
		{
			sessionFactory.getCurrentSession().save(vendor);
			
			return true;
		}
		
		catch (Exception e) 
		{	
			return false;
			// TODO: handle exception
		}


	}



	@Override
	public boolean deleteVendor(Vendor vendor) {
		try
		{
			sessionFactory.getCurrentSession().delete(vendor);
			
			return true;
		}
		
		catch (Exception e) 
		{	
			return false;
			// TODO: handle exception
		}

	}



	@Override
	public Vendor login(String email, String password) 
	{
    	Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor where email=:email and password=:password",Vendor.class);
        query.setParameter("email",email);
        query.setParameter("password",password);
        return query.getSingleResult();
	     
		

	}



	@Override
	public Vendor getVendor(int id) {

		try
		{
			return sessionFactory.getCurrentSession().get(Vendor.class,id);
		}
		catch (Exception e) 
		{
			return null;

		}

	}



}
