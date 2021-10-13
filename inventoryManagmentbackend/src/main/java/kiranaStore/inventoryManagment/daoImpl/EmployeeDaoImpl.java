package kiranaStore.inventoryManagment.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.inventoryManagment.dao.EmployeeDao;
import kiranaStore.inventoryManagment.databaseConfig.DbConfig;
import kiranaStore.inventoryManagment.dto.Customer;
import kiranaStore.inventoryManagment.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	DbConfig dbConfig;
	PreparedStatement stmt;

	public EmployeeDaoImpl() {
		dbConfig = DbConfig.getDbConfig(); // we can't create becs its private
											// so use getconfig
	}

	public Boolean add(Employee emp) {
		try {
			// stmt = dbConfig.getCon().
			stmt = dbConfig.getCon()
					.prepareStatement("INSERT into Employee(empId,empName,salary,jobtitle)VALUES(?,?,?,?);");

			stmt.setInt(1, emp.getEmpId());
			stmt.setString(2, emp.getEmpName());
			stmt.setInt(3, emp.getSalary());
			stmt.setString(4, emp.getJobTitle());

			int rowAffected = stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			// System.out.println(e);
			e.printStackTrace();
			return false;

		}

	}

	public Boolean update(Employee emp) {
		// TODO Auto-generated method stub
		try{
			stmt= dbConfig.getCon().prepareStatement("Update Employee set empName=?, salary=?, jobtitle=? where empId=?" );
					
			
			stmt.setString(1, emp.getEmpName());
			stmt.setInt(2, emp.getSalary());
			stmt.setString(3, emp.getJobTitle());
			stmt.setInt(4, emp.getEmpId());
					int i=stmt.executeUpdate();
					return true;
					
					
					
		}catch(SQLException e)
		{
			e.printStackTrace();return false;
		}
	}

	public Boolean delete(Integer empId) {
		try {

			stmt = dbConfig.getCon().prepareStatement("delete from Employee where empId =" + empId);
			int rs = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Employee searchById(Integer empId) {

		ResultSet rs = null;
		Employee emp = null;
		try {
			stmt = dbConfig.getCon().prepareStatement("Select * from Employee where empId =" + empId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt("empId"));
				emp.setEmpName(rs.getString("empName"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobTitle(rs.getString("jobtitle"));
				// int n=stmt.executeUpdate();
				return emp;

			}
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	public List<Employee> EmployeeList()
	{
		List<Employee> list=new ArrayList<Employee>();
		ResultSet rs = null;
		Employee emp = null;
		try {
			stmt = dbConfig.getCon().prepareStatement("Select * from Employee ");
			rs = stmt.executeQuery();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt("empId"));
				emp.setEmpName(rs.getString("empName"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobTitle(rs.getString("jobtitle"));
				// int n=stmt.executeUpdate();
				//return emp;
				list.add(emp);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}

