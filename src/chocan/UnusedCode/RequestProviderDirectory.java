package chocan.UnusedCode;
import java.util.ArrayList;

import chocan.ProviderDirectory;
import chocan.ProviderDirectoryEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class RequestProviderDirectory {

    private ProviderDirectory provideDirect;
    
    public RequestProviderDirectory() {
        
    }
    
    public void emailDirectory() {
        
    }
    
    public ArrayList<ProviderDirectoryEntry> ReadProviderDirectoryEntry() throws FileNotFoundException, IOException {
        String filename = "/Users/ashleyphan/git/cs200fall2018team2/src/chocan/writtenFiles/ProviderReports/providerDirectory.txt";
        Path pPath = Paths.get(filename);
      
        File mFile = pPath.toFile();
        
        
        ArrayList<ProviderDirectoryEntry> listPde = new ArrayList<ProviderDirectoryEntry>();
        
        if(Files.exists(pPath)){
            try(BufferedReader input = new BufferedReader(new FileReader(mFile))){
                String line = input.readLine();
            
                while (line != null && !line.equals("")) {
                    String[] fields = line.split(",");
                    ProviderDirectoryEntry entry = new ProviderDirectoryEntry();
                    
                    entry.setServiceName(fields[0]);
                    entry.setServiceCode(Integer.parseInt(fields[1]));
                    entry.setServiceFee(Integer.parseInt(fields[2]));
                    
                    listPde.add(entry);
                    line = input.readLine();
                }
            }
        }
        return listPde;
    }

}
