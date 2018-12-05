/*
 * Author: Ashley Phan
 */

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
	
	public static boolean findEntry(int code) throws FileNotFoundException,IOException{
        ArrayList<ProviderDirectoryEntry> pde = Terminal.ReadProviderDirectoryEntry();
        ProviderDirectoryEntry entry = new ProviderDirectoryEntry();
        boolean flag = false;
        for (ProviderDirectoryEntry pd : pde) {
            if (pd.getServiceCode() == code) {
                entry = pd;
                flag = true;
            }
        }
        
        return flag;
    }

}
