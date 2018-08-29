package demo.project.tables.dao;

import demo.project.tables.model.Address;

public interface AddressService 
{
	public abstract boolean addAddress(Address address);
	public abstract boolean deleteAddress(Address address);
}
