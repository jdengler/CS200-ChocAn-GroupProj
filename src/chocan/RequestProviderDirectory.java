package chocan;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class RequestProviderDirectory {

    private ProviderDirectory provideDirect;
    
    public RequestProviderDirectory() {
        
    }
    
    public void emailDirectory() {
        
    }
    
    public void printDirectory() throws IOException {
            provideDirect = new ProviderDirectory();
            ArrayList<ProviderDirectoryEntry> list = provideDirect.getProviderDirectory();
            FileWriter writer = new FileWriter("Provider Directory");
            
            for (ProviderDirectoryEntry entry : list){
                writer.write(entry.getServiceName() + "\t");
                writer.write(entry.getServiceCode() + "\t");
                writer.write(entry.getServiceFee()  + "\n");
            }
            
    }

}
