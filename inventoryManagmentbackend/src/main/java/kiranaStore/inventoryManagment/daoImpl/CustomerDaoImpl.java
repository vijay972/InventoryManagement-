package kiranaStore.inventoryManagment.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.inventoryManagment.dao.CustomerDao;
import kiranaStore.inventoryManagment.databaseConfig.DbConfig;
import kiranaStore.inventoryManagment.dto.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	DbConfig dbConfig;
	PreparedStatement stmt;

	public CustomerDaoImpl() {
		dbConfig = DbConfig.getDbConfig(); // we can't create becs its private
											// so use getconfig
	}

	public Boolean add(Customer c) {
		try {
			// stmt = dbConfig.getCon().
			stmt = dbConfig.getCon().prepareStatement("INSERT into customer(cid,cName,cPhone,cAge)VALUES(?,?,?,?);");

			stmt.setInt(1, c.getcId());
			stmt.setString(2, c.getcName());
			stmt.setString(3, c.getcPhone());
			stmt.setInt(4, c.getcAge());

			int rowAffected = stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			// System.out.println(e);
			e.printStackTrace();
			return false;

		}

		// return null;
	}

	public Boolean update(Customer c) {
		
		try{
			stmt= dbConfig.getCon().prepareStatement("Update Customer set cName=?, cPhone=?, cAge=? where cid=?" );
					
					stmt.setString(1, c.getcName());
					stmt.setString(2, c.getcPhone());
					stmt.setInt(3, c.getcAge());
					stmt.setInt(4, c.getcId());
					int i=stmt.executeUpdate();
					return true;
					
					
					
		}catch(SQLException e)
		{
			e.printStackTrace();return false;
		}

	}

	public Boolean delete(Integer cid) {

		try {

			stmt = dbConfig.getCon().prepareStatement("delete from Customer where cid =" + cid);
			int rs = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Customer searchById(Integer cid) {
		ResultSet rs = null;
		Customer cust = null;
		try {
			stmt = dbConfig.getCon().prepareStatement("Select * from customer where cid =" + cid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				cust = new Customer();
				cust.setcId(rs.getInt("cid"));
				cust.setcName(rs.getString("cName"));
				cust.setcPhone(rs.getString("cPhone"));
				cust.setcAge(rs.getInt("cAge"));
				// int n=stmt.executeUpdate();
				return cust;

			}
			return cust;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Customer> customerList()
	{
		List<Customer> custlist=new ArrayList<Customer>();
		ResultSet rs = null;
		Customer cust = null;
		try {
			stmt = dbConfig.getCon().prepareStatement("Select * from customer");
			rs = stmt.executeQuery();
			while (rs.next()) {
				cust = new Customer();
				cust.setcId(rs.getInt("cid"));
				cust.setcName(rs.getString("cName"));
				cust.setcPhone(rs.getString("cPhone"));
				cust.setcAge(rs.getInt("cAge"));
				// int n=stmt.executeUpdate();
				custlist.add(cust);
				//return list;

			}
			return custlist;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}


