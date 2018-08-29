package demo.project.tables.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component("subCategory")
public class SubCategory 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subc_id;
	private String subc_name;
	

	@ManyToOne
	private Category category;
	
	public int getSubc_id() {
		return subc_id;
	}
	public void setSubc_id(int subc_id) {
		this.subc_id = subc_id;
	}
	public String getSubc_name() {
		return subc_name;
	}
	public void setSubc_name(String subc_name) {
		this.subc_name = subc_name;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
