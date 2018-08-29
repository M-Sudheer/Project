//AppTest
package demo.project.tables;

import static org.junit.Assert.assertEquals;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import demo.project.tables.Imp.VendorServiceImp;
import demo.project.tables.dao.AddressService;
import demo.project.tables.dao.CategoryService;
import demo.project.tables.dao.ProductService;
import demo.project.tables.dao.SubCategoryService;
import demo.project.tables.dao.VendorService;
import demo.project.tables.model.Address;
import demo.project.tables.model.Category;
import demo.project.tables.model.Products;
import demo.project.tables.model.SubCategory;
import demo.project.tables.model.Vendor;
import demo.project.tables.products.Laptop;
import demo.project.tables.productsDao.LaptopService;

@SpringJUnitConfig(classes={HibernateConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest
{
	@Autowired
	private Vendor vendor;
	@Autowired
	private Address address;
	@Autowired
	private Category category;
	@Autowired
	private SubCategory subCategory;
	@Autowired
	private Laptop laptop;
	
	
	
	@Autowired
	private VendorService vendorSevice;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private LaptopService laptopService;
	

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Before
	public  void setUp()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new  AnnotationConfigApplicationContext(HibernateConfig.class);
		
		vendor.setCompanyName("Amazon");
		vendor.setEmail("kevin@gmail.com");
		vendor.setMobile("9488770075");
		vendor.setName("kevin");
		vendor.setPassword("kevin");
		vendor.setConfirmPassword("kevin");
		
		
		address.setStreetNo(2);
		address.setCity("Hyderabad");
		address.setDistrict("Telangana");
	
		
		
		laptop.setRam("8gb");
		laptop.setRom("4gb");
		laptop.setProcessor("i7");
	}
	
	
	@Test
	public void addVendorTest()
	{
		assertEquals("Test vendor adding Failed",true,vendorSevice.addVendor(vendor));
		deleteVendor();
	}
	public void deleteVendor()
	{
		vendorSevice.deleteVendor(vendor);
	}
	
	
	
	@Test
	public void addAddress()
	{
		assertEquals("Test address adding failed",true,addressService.addAddress(address));
		deleteAddress();
	}
	public void deleteAddress()
	{
		addressService.deleteAddress(address);
	}
	
	
	
	@Test
	public void addLaptop()
	{
		subCategory=subCategoryService.getSubCategory(1);
		vendorSevice.addVendor(vendor);
		laptop.setVendor(vendor);
		laptop.setSubCategory(subCategory);
		assertEquals("Test Insertion laptop failed",true,laptopService.addLaptop(laptop));
		deleteLaptop();
		deleteVendor();
	}
	private void deleteLaptop() 
	{
	laptopService.deleteLaptop(laptop);
	}
}