package kiranaStore.inventoryManagment.dto;

import java.sql.*;

public class Order {
	
	private Integer orderId;
	private Integer empId;
	private Integer cId;
	private Integer pId;
	private Integer orderQuantity;
	private Timestamp orderDate;
	private Integer totalPrice;
	
	public Order()
	{
		
	}

	public Order(Integer orderId, Integer empId, Integer cId, Integer pId, Integer orderQuantity, Timestamp orderDate,
			Integer totalPrice) {
		super();
		this.orderId = orderId;
		this.empId = empId;
		this.cId = cId;
		this.pId = pId;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() 
	{
		return "Order [orderId=" + orderId + ", empId=" + empId + ", cid=" + cid + ", pId=" + pId + ", orderQuantity="
				+ orderQuantity + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + "]";
	}
	
	

}
