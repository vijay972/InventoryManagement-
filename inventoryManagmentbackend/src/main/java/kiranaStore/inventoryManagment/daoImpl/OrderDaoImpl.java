package kiranaStore.inventoryManagment.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.inventoryManagment.dao.OrderDao;
import kiranaStore.inventoryManagment.dao.ProductDao;
import kiranaStore.inventoryManagment.databaseConfig.DbConfig;
import kiranaStore.inventoryManagment.dto.Order;
import kiranaStore.inventoryManagment.dto.Product;

public class OrderDaoImpl implements OrderDao {
	
	//point 1
		//cal the total price and  grand total pricce for same customer 101
		//2 Television 2*25000=50000(total price)
		//3 mobile 3*15000=45000(total price)
		// total grand price 50000+45000= 95000
		
		
		//point 2
		//buying quantity must be minus from product availability
		//productavailabilty - orderquantity;
		
		DbConfig dbConfig;
		PreparedStatement stmt;
		private ProductDao productDao;
		public OrderDaoImpl()
		{
			dbConfig = DbConfig.getDbConfig(); 
			productDao=new ProductDaoImpl();
			
		}
		
		
		
		public Boolean add(Order ord) {
			try
			{
				//stmt = dbConfig.getCon().
			stmt = dbConfig.getCon().prepareStatement("INSERT into OrderTable(orderId,empId,cid,pID,orderQuantity,orderDate,totalprice)VALUES(?,?,?,?,?,?,?);");
			
			Integer orderId=ord.getOrderId();
			Integer empId=ord.getEmpId();
			Integer cid=ord.getcId();
			Integer pID=ord.getpId();
			Integer orderQuantity=ord.getOrderQuantity();
			//Date date = new Date();
			//Timestamp orderDate=new Timestamp(new Date().getTime());
			Timestamp instant= Timestamp.from(Instant.now());  
			Integer totalPrice=ord.getTotalPrice();
			
			Product product=productDao.searchById(pID);
			if(product.getProAvailability()<orderQuantity)
			{
				throw new ArithmeticException("We dont have enough quantity of "+ product.getProName()+" . We have only "+ product.getProAvailability());
			}
			if(totalPrice <=0 || totalPrice==null)
			{
				throw new NullPointerException("You must buy atleast one product");
			}
			
			stmt.setInt(1, orderId);
			stmt.setInt(2, empId);
			stmt.setInt(3, cid);
			stmt.setInt(4, pID);
			stmt.setInt(5, orderQuantity);
			stmt.setTimestamp(6, instant);
			stmt.setInt(7, totalPrice);
			
			int i=stmt.executeUpdate();
			stmt=null;
			stmt=dbConfig.getCon().prepareStatement("Update product set proAvailability=? where pID=?");
			Integer remainingQuantity= product.getProAvailability()-orderQuantity;
			stmt.setInt(1, remainingQuantity);
			stmt.setInt(2, product.getpId());
			
			i=stmt.executeUpdate();
			return true;
			
			
			
			
			}
			catch(SQLException | ArithmeticException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				return false;
				
			}
			
			
		}

		public Boolean update(Order ord) {
			try{
				stmt= dbConfig.getCon().prepareStatement("Update Customer set orderQuantity where orderid=?" );
						
						
						stmt.setInt(5, ord.getOrderQuantity());
						int i=stmt.executeUpdate();
						return true;
						
						
						
			}catch(SQLException e)
			{
				e.printStackTrace();return false;
			}
			
		}

		public Boolean delete(Integer orderId) {
			try {

				stmt = dbConfig.getCon().prepareStatement("delete from ordertable where orderid =" + orderId);
				int rs = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
			
		}

		public Order searchById(Integer orderId) {
			ResultSet rs = null;
			Order order = null;
			try {
				stmt = dbConfig.getCon().prepareStatement("Select * from ordertable where orderId="+ orderId);
				rs = stmt.executeQuery();
				if (rs.next()) {
					order = new Order();
					order.setOrderId(rs.getInt("orderId"));
					order.setEmpId(rs.getInt("empId"));
					order.setcId(rs.getInt("cid"));
					order.setpId(rs.getInt("pID"));
					order.setOrderQuantity(rs.getInt("orderQuantity"));
					order.setOrderDate(rs.getTimestamp("orderDate"));
					order.setTotalPrice(rs.getInt("totalPrice"));
					// int n=stmt.executeUpdate();
					return order;

				}
				return order;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}



		public List<Order> orderList() {
			
			List<Order> orderlist=new ArrayList<Order>();
			ResultSet rs = null;
			Order order = null;
			try {
				stmt = dbConfig.getCon().prepareStatement("Select * from OrderTable");
				rs = stmt.executeQuery();
				while (rs.next()) {
					order = new Order();
					order.setOrderId(rs.getInt("orderId"));
					order.setEmpId(rs.getInt("empId"));
					order.setcId(rs.getInt("cid"));
					order.setpId(rs.getInt("pID"));
					order.setOrderQuantity(rs.getInt("orderQuantity"));
					order.setOrderDate(rs.getTimestamp("orderDate"));
					order.setTotalPrice(rs.getInt("totalPrice"));
					
					// int n=stmt.executeUpdate();
					orderlist.add(order);
				
				}
				return orderlist;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
			
		}

	}


