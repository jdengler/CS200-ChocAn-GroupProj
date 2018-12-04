package chocan;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ProviderDirectory {
	

	public ProviderDirectory() {
		
	}

	
	public static ProviderDirectoryEntry validEntry(int code) throws FileNotFoundException,IOException{
        ArrayList<ProviderDirectoryEntry> pde = Terminal.ReadProviderDirectoryEntry();
        ProviderDirectoryEntry entry = new ProviderDirectoryEntry();
        for (ProviderDirectoryEntry pd : pde) {
            if (pd.getServiceCode() == code) {
                entry = pd;
            }
        }
        
        return entry;
    }

}
