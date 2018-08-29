
package demo.project.tables.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import demo.project.tables.products.Laptop;

@Entity
@Component("vendor")
public class Vendor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vid;
	
	private String companyName;
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String mobile;
	@Column(unique=true)
	private String name;
	private String password;


	
	
	@OneToMany(mappedBy="vendor")
	private List<Products> Productss;
	
	@OneToMany
	private List<Address> Addresses;
	



	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public int getVid() 
	{
		return vid;
	}
	public void setVid(int vid) 
	{
		this.vid = vid;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getMobile() 
	{
		return mobile;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
	public String getCompanyName() 
	{
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	//h
	public List<Products> getProductss() {
		return Productss;
	}
	public void setProductss(List<Products> productss) {
		Productss = productss;
	}
	
	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", companyName="
				+ companyName + "]";
	}
}


