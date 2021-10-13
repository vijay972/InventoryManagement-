package kiranaStore.inventoryManagment.databaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.jdbc.PreparedStatement;

public class DbConfig {

	public Connection con;
	public static DbConfig dbConfig;
	
	
	 private String URL = "jdbc:mysql://localhost:3306/inventorystore?autoReconnect=true&useSSl=false"; //database url
	 private String username = "root"; //database username
	 private String password = "Varun@26"; //database password
	
	public DbConfig(Connection con) {
		super();
		this.con = con;
	}

	private DbConfig() {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
			
		}
		try{
			con = DriverManager.getConnection(URL, username, password);
			//java.sql.PreparedStatement stmt = con.prepareStatement("INSERT intp customer(cid,cName,cPhone,cAge)VALUES(?,?,?,?);");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	public static DbConfig getDbConfig()
	{
		if(dbConfig ==null)
		{
			dbConfig=new DbConfig();
			return dbConfig;
		}
		else
		{
			return dbConfig;
		}
	}
	public void finalize()
	{
		try{
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}

	public Connection getCon() {
		// TODO Auto-generated method stub
		return con;
	}

	
}

