package chocan;
import java.util.ArrayList;

public class ProviderDirectory {
	
	private ArrayList<ProviderDirectoryEntry> providerDirectoryEntries;

	public ProviderDirectory() {
		
	}
	
	public ProviderDirectory(ArrayList<ProviderDirectoryEntry> providerDirectoryEntries) {
		super();
		this.providerDirectoryEntries = providerDirectoryEntries;
	}
	
	public ProviderDirectoryEntry findProviderDirectoryEntry(int serviceCode){
		for(ProviderDirectoryEntry pde : providerDirectoryEntries){
			if(pde.getServiceCode() == serviceCode){
				return pde;
			}
		}
		return null;
	}
	
	public void AddEntry(String serviceName, int serviceCode, double serviceFee) {
		ProviderDirectoryEntry pde = new ProviderDirectoryEntry(serviceName, serviceCode, serviceFee);
		providerDirectoryEntries.add(pde);
	}
	
	public ArrayList<ProviderDirectoryEntry> getProviderDirectory() {
	    return providerDirectoryEntries;
	}
}
