package kiranaStore.inventoryManagment.dao;

import java.util.List;

import kiranaStore.inventoryManagment.dto.Customer;

public interface CustomerDao {
	
	public Boolean add(Customer c);
	
	public Boolean update(Customer c);
	
	public Boolean delete(Integer cid);
	
	public Customer searchById(Integer cid);
	
	public List<Customer> customerList();

}
