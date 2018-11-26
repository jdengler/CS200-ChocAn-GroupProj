package chocan;

public class ProviderDirectoryEntry {
	
	private String serviceName;
	private int serviceCode;
	private double serviceFee;
	
	public ProviderDirectoryEntry() {
		
	}
	
	public ProviderDirectoryEntry(String serviceName, int serviceCode, double serviceFee) {
		super();
		this.serviceName = serviceName;
		this.serviceCode = serviceCode;
		this.serviceFee = serviceFee;
	}
	
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(int serviceCode) {
		this.serviceCode = serviceCode;
	}

	public double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

}
