package demo.project.tables.products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import demo.project.tables.model.Products;

@Entity
@Component
public class Laptop extends Products
{
	private String ram;
	private String rom;
	private String processor;
	
	public String getRam()
	{
		return ram;
	}
	public void setRam(String ram) 
	{
		this.ram = ram;
	}
	public String getRom() 
	{
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	
}
