package chocan;
import java.util.ArrayList;
import java.io.FileWriter;

public class RequestProviderDirectory {

    private ProviderDirectory provideDirect;
    
    public RequestProviderDirectory() {
        
    }
    
    public void emailDirectory() {
        
    }
    
    public void printDirectory() {
            provideDirect = new ProviderDirectory();
            ArrayList<ProviderDirectoryEntry> list = provideDirect.getProviderDirectory();
            FileWriter writer = new FileWriter("Provider Directory");
            for (ProviderDirectoryEntry: arr){
                
            }
    }

}
