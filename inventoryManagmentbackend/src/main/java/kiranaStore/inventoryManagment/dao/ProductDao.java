package kiranaStore.inventoryManagment.dao;

import java.util.List;

import kiranaStore.inventoryManagment.dto.Product;

public interface ProductDao {
	
	public Boolean add(Product pro);
	
	public Boolean update(Product pro);
	
	public Boolean delete(Integer proId);
	
	public Product searchById(Integer proId);
	
	public List<Product> productList();
}
