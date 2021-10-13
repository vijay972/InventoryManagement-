package kiranaStore.inventoryManagment.dto;

public class Customer {
	
	private Integer cId;
	private String cName;
	private String cPhone;
	private Integer cAge;
	
	public Customer()
	{
		
	}
	
	public Customer(Integer cId, String cName, String cPhone, Integer cAge) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cAge = cAge;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public Integer getcAge() {
		return cAge;
	}

	public void setcAge(Integer cAge) {
		this.cAge = cAge;
	}
	
	@Override
	public String toString() {
		return String.format("|%-10d | %-30s | %-30s | %d |",cId,cName,cPhone,cAge);
	//	return "Customer [cId=" + cId + ", cName=" + cName + ", cPhone=" + cPhone + ", cAge=" + cAge + "]";
	}
	
	

}
