package kiranaStore.inventoryManagment;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

import kiranaStore.inventoryManagment.dao.CustomerDao;
import kiranaStore.inventoryManagment.dao.EmployeeDao;
import kiranaStore.inventoryManagment.dao.OrderDao;
import kiranaStore.inventoryManagment.dao.ProductDao;
import kiranaStore.inventoryManagment.daoImpl.CustomerDaoImpl;
import kiranaStore.inventoryManagment.daoImpl.EmployeeDaoImpl;
import kiranaStore.inventoryManagment.daoImpl.OrderDaoImpl;
import kiranaStore.inventoryManagment.daoImpl.ProductDaoImpl;
import kiranaStore.inventoryManagment.dto.Customer;
import kiranaStore.inventoryManagment.dto.Employee;
import kiranaStore.inventoryManagment.dto.Order;
import kiranaStore.inventoryManagment.dto.Product;
public class Test {

	CustomerDao custdao=new CustomerDaoImpl();
	EmployeeDao empdao=new EmployeeDaoImpl();
	ProductDao prodao=new ProductDaoImpl();
	OrderDao orderdao=new OrderDaoImpl();
	
	Scanner sc=new Scanner(System.in);
	Customer cust;
	Employee emp;
	Product pro;
	Order or;
	public Test(){
		custdao=new CustomerDaoImpl();
		 empdao=new EmployeeDaoImpl();
		prodao=new ProductDaoImpl();
		 orderdao=new OrderDaoImpl();
		 
		 cust=new Customer();
		 emp=new Employee();
		 pro=new Product();
		 or=new Order();
		
		
	}
	public void addCustomer(){
		//this.cust=cust;
		Customer cust=new Customer();
		System.out.println("enter id\n");
		Integer cid = Integer.parseInt(sc.nextLine());
		System.out.println("Enter name\n");
		String name = sc.nextLine();
		System.out.println("Enter phone number\n");
		String pno = sc.nextLine();
		System.out.println("Enter age\n");
		Integer age = Integer.parseInt(sc.nextLine());
		Customer c = new Customer(cid, name, pno, age);
		custdao.add(c);
		
		System.out.println("CUSTOMER\n" + custdao);
		
	}
	public void displayCustomers()
	{
		java.util.List<Customer> list=custdao.customerList();
		System.out.println("CUSTOMER DETAILS ARE");
		System.out.printf("|%-10s | %-30s | %-30s | %s |","CustomerId","CustomerName","PhoneNO","CustomerAge\n");
		for(Customer c:list)
		{
			System.out.println(c);
		}
		
	}
	public void displayOneCustomer()
	{
		System.out.println("Enter customer id for search\n");
		Integer searchCid = Integer.parseInt(sc.nextLine());
		Customer c1 = custdao.searchById(searchCid);
		System.out.println("Your Searching Customer is " + searchCid );
		System.out.printf("|%-10s | %-30s | %-30s | %s |\n","CustomerId","CustomerName","PhoneNO","CustomerAge");
		
		if(c1==null)
		{
			System.out.println("NO data found with your searching customer id");
		}
		else
		{
		System.out.println( c1.toString());
		}
	}
	public void addEmployee(){
		//this.emp=emp;
		
		Employee emp=new Employee();
		System.out.println("enter id\n");
		Integer Empid = Integer.parseInt(sc.nextLine());
		System.out.println("Enter name\n");
		String Empname = sc.nextLine();
		System.out.println("Enter job Title\n");
		String jobtitle = sc.nextLine();
		System.out.println("Enter salary\n");
		Integer salary = Integer.parseInt(sc.nextLine());
		Employee em = new Employee(Empid, Empname, salary, jobtitle);
		empdao.add(em);
		System.out.println("EMPLOYEE\n"+ empdao);
	}
	public void displayEmployees()
	{
		java.util.List<Employee> list=empdao.EmployeeList();
		System.out.println("EMPLOYEE DETAILS ARE\n");
		System.out.printf("|%-15s | %-30s | %-30s | %s |\n","Employee Id","Employee Name","Salary","Job title");
		for(Employee e:list)
		{
			System.out.println(e);
		}
		
	}
	public void displayOneEmployee()
	{
		
		System.out.println("Enter Employee id for search\n");
		Integer searchEid = Integer.parseInt(sc.nextLine());
		Employee emp = empdao.searchById(searchEid);
		System.out.println("Your Searching Customer is " + searchEid );
		System.out.printf("|%-15s | %-30s | %-30s | %s |\n","Employee Id","Employee Name","Salary","Job title");
		
		if(emp==null)
		{
			System.out.println("NO data found with your searching Employee id");
		}
		else
		{
		System.out.println( emp.toString());
		}
		
	}
	public void addOrder(){
		//this.or=or;
		Order or=new Order();
		System.out.println("Enter order Id");
		Integer oid=Integer.parseInt(sc.nextLine());
		or.setOrderId(oid);
		System.out.println("Enter product Id");
		Integer pid=Integer.parseInt(sc.nextLine());
		or.setpId(pid);
		System.out.println("Enter customer id");
		Integer cid=Integer.parseInt(sc.nextLine());
		or.setcId(cid);
		System.out.println("Enter employee id");
		Integer eid=Integer.parseInt(sc.nextLine());
		or.setEmpId(eid);
		System.out.println("order quantity");
		Integer quantity=Integer.parseInt(sc.nextLine());
		or.setOrderQuantity(quantity);
		if(prodao.searchById(pid).getProPrice()==0)
		{
			System.out.println("The product is not found");
		}
		 Integer totalPrice = (or.getOrderQuantity() * prodao.searchById(pid).getProPrice());
		 Timestamp instant= Timestamp.from(Instant.now());  
		 or.setOrderDate(instant);
		 or.setTotalPrice(totalPrice);
		// Order order=new Order(oid,eid,cid,pid,quantity,instant,totalPrice);
		  System.out.println(orderdao.add(or));
		
		/*  Integer productId = 2;
	        or.setCid(1);
	        or.setEmpId(1);
	        or.setOrderDate(null);
	        or.setOrderId(2);
	        or.setpId(productId);
	        or.setOrderQuantity(3);
	        Integer totalPrice = (or.getOrderQuantity() * prodao.searchById(productId).getProPrice());
	        or.setTotalPrice(totalPrice);
	        System.out.println(orderdao.add(or));*/
		
		
	}
	public void displayOrders()
	{
		java.util.List<Order> list=orderdao.orderList();
		for(Order p:list)
		{
			System.out.println(p);
		}
	}
	public void displayOneOrder()
	{
		
		System.out.println("Enter Order id for search\n");
		Integer searchOid = Integer.parseInt(sc.nextLine());
		Order order = orderdao.searchById(searchOid);
		System.out.println("Your Searching Customer is " + searchOid );
		System.out.printf("|%-5s | %-5s | %-5s | %-5s |%-5s|%-10s|%s\n","Order id","Employee id","Customer id","ProductId","Order Quantity","orderDate","Price Amount");
		
		if(order==null)
		{
			System.out.println("NO data found with your searching order id");
		}
		else
		{
		System.out.println( order.toString());
		}
		
	}
	public void addProduct(){
		//this.or=or;
		Order or=new Order();
		System.out.println("enter product id\n");
		Integer proid = Integer.parseInt(sc.nextLine());
		System.out.println("Enter product name\n");
		String proname = sc.nextLine();
		System.out.println("Enter product price\n");
		Integer price = Integer.parseInt(sc.nextLine());
		System.out.println("Enter product availability\n");
		Integer avail = Integer.parseInt(sc.nextLine());
		Product pro = new Product(proid, proname, price, avail);
		prodao.add(pro);
		System.out.println("PRODUCT" + prodao);
	}
	public void displayProducts()
	{
		java.util.List<Product> list=prodao.productList();
		System.out.println("PRODUCT DETAILS ARE");
		System.out.printf("|%-10s | %-30s | %-30s | %s |\n","ProductId","ProductName","Product Price","ProductAvailablity");
		for(Product p:list)
		{
			System.out.println(p);
		}
		
	}
	public void displayOneProduct()
	{
		System.out.println("Enter product id for search\n");
		Integer searchPid = Integer.parseInt(sc.nextLine());
		Product pro = prodao.searchById(searchPid);
		System.out.println("Your Searching Customer is " + searchPid );
		System.out.printf("|%-10s | %-30s | %-30s | %s |\n","ProductId","ProductName","ProductPrice","ProductAvaiability");
		
		if(pro==null)
		{
			System.out.println("NO data found with your searching product id");
		}
		else
		{
		System.out.println( pro.toString());
		}
		
		
	}
	

}

