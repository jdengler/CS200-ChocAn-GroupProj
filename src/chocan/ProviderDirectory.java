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
	
	public ArrayList<ProviderDirectoryEntry> getProviderDirectory() {
	    return providerDirectoryEntries;
	}
}
