package demo.project.tables.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Address 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int address_id;
	private int streetNo;
	private String city;
	private String district;

	@ManyToMany
	private Vendor vendor;
	
	
	public int getAddress_id() 
	{
		return address_id;
	}
	public void setAddress_id(int address_id) 
	{
		this.address_id = address_id;
	}
	public int getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(int streetNo) 
	{
		this.streetNo = streetNo;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getDistrict() 
	{
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
}
