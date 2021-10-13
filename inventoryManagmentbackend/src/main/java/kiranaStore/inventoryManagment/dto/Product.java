package kiranaStore.inventoryManagment.dto;

public class Product {
	
	private Integer pId;
	private String proName;
	private Integer proPrice;
	private Integer proAvailability;

	public Product()
	{
		
	}

	public Product(Integer pId, String proName, Integer proPrice, Integer proAvailability) {
		super();
		this.pId = pId;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proAvailability = proAvailability;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Integer getProPrice() {
		return proPrice;
	}

	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}

	public Integer getProAvailability() {
		return proAvailability;
	}

	public void setProAvailability(Integer proAvailability) {
		this.proAvailability = proAvailability;
	}

	@Override
	public String toString() {
		return String.format("|%-10s | %-30s | %-30s | %s |", pId,proName,proPrice,proAvailability);
	// "Product [pId=" + pId + ", proName=" + proName + ", proPrice=" + proPrice + ", proAvailablity="
		//		+ proAvailablity + "]";
	}

	
}
