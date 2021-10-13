package kiranaStore.inventoryManagment.dao;

import java.util.List;

import kiranaStore.inventoryManagment.dto.Employee;

public interface EmployeeDao {

	public Boolean add(Employee emp);
	
	public Boolean update(Employee emp);
	
	public Boolean delete(Integer empId);
	
	public Employee searchById(Integer empId);
	
	public List<Employee> EmployeeList();

}
