//ProductService
package demo.project.tables.dao;

import demo.project.tables.model.Products;
import demo.project.tables.model.Vendor;

public interface ProductService
{
		public abstract boolean addProducts(Products products);
		public abstract boolean deleteProducts(Products products);
	

}
