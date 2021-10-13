package kiranaStore.inventoryManagment.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.inventoryManagment.dao.ProductDao;
import kiranaStore.inventoryManagment.databaseConfig.DbConfig;
import kiranaStore.inventoryManagment.dto.Employee;
import kiranaStore.inventoryManagment.dto.Product;


public class ProductDaoImpl implements ProductDao{
	
	DbConfig dbConfig;
	PreparedStatement stmt;
	public ProductDaoImpl() {
		dbConfig = DbConfig.getDbConfig(); // we can't create becs its private
											// so use getconfig
	}
	
	public Boolean add(Product pro) {
		try
		{
			//stmt = dbConfig.getCon().
		stmt = dbConfig.getCon().prepareStatement("INSERT into Product(pID,proName,proPrice,proAvailability)VALUES(?,?,?,?);");
		
		stmt.setInt(1, pro.getpId());
		stmt.setString(2, pro.getProName());
		stmt.setInt(3, pro.getProPrice());
		stmt.setInt(4, pro.getProAvailability());
		
		int rowAffected=stmt.executeUpdate();
		return true;
		
		}
		catch(SQLException e)
		{
			//System.out.println(e);
			e.printStackTrace();
			return false;
			
		}
	}

	public Boolean update(Product pro) {
		// TODO Auto-generated method stub
		try{
			stmt= dbConfig.getCon().prepareStatement("Update Product set proName=?, proPrice=?, proAvailability=? where pID=?" );
					
			
			stmt.setInt(4, pro.getpId());
			stmt.setString(1, pro.getProName());
			stmt.setInt(2, pro.getProPrice());
			stmt.setInt(3, pro.getProAvailability());
			
					int i=stmt.executeUpdate();
					return true;
					
					
					
		}catch(SQLException e)
		{
			e.printStackTrace();return false;
		}
		
	}

	public Boolean delete(Integer proId) {
		try{
			
			
			stmt=dbConfig.getCon().prepareStatement("delete from Customer where pId ="+proId);
			int rs=stmt.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();
			}

		return null;
	}

	public Product searchById(Integer proId) {
		ResultSet rs=null;
		Product prod=null;
		try{
			stmt=dbConfig.getCon().prepareStatement("Select * from product where pID ="+proId);
				rs=stmt.executeQuery();
			if(rs.next())
			{
				prod=new Product();
				prod.setpId(rs.getInt("pID"));
				prod.setProName(rs.getString("proName"));
				prod.setProPrice(rs.getInt("proPrice"));
				prod.setProAvailability(rs.getInt("proAvailability"));
				//int n=stmt.executeUpdate();
				return prod;
				
			}
		return prod;
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return null;
		
	}

	public List<Product> productList()
	{
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<Product>();
		ResultSet rs=null;
		Product prod=null;
		try{
			stmt=dbConfig.getCon().prepareStatement("Select * from product");
				rs=stmt.executeQuery();
			if(rs.next())
			{
				prod=new Product();
				prod.setpId(rs.getInt("pID"));
				prod.setProName(rs.getString("proName"));
				prod.setProPrice(rs.getInt("proPrice"));
				prod.setProAvailability(rs.getInt("proAvailability"));
				//int n=stmt.executeUpdate();
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}


