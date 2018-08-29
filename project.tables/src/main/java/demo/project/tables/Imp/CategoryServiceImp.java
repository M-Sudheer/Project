package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.CategoryService;
import demo.project.tables.model.Category;


@Component
@Transactional
public class CategoryServiceImp implements CategoryService
{
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public boolean addCategory(Category category) {


		try
		{
			sessionFactory.getCurrentSession().save("category");
		
			return false;
		}
		
		catch (Exception e) {
			// TODO: handle exception
		
		
		return false;
	}

	}
}
