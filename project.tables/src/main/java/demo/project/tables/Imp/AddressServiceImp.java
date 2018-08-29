package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.AddressService;
import demo.project.tables.model.Address;

@Component
@Transactional
public class AddressServiceImp implements AddressService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addAddress(Address address) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(address);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteAddress(Address address) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(address);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}	
	}
}
