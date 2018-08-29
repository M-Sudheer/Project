package demo.project.tables.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component("category")
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int c_id;
	private String c_name;
	

	@OneToMany(mappedBy="category")
	private Set<SubCategory> subCategory;

	
	public Set<SubCategory> getSubCategories() {
		return subCategory;
	}
	public void setSubCategories(Set<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	

}
