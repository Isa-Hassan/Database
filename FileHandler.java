
package za.ac.cput.dentistappointment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author User
 */
public class FileHandler {
        FileWriter fw;
    BufferedWriter bw;
    
    public void openFile(String fileName) {
    	try {
    	
        fw = new FileWriter("Appointments.txt", true);
        bw = new BufferedWriter(fw);
    	}
    	catch(IOException ewe) {
    		System.out.println(ewe);
    		System.out.println("File not found");
    		
    	}
    			
    }
    
    public void processFile(String rec) throws IOException {
       
    	try
    	{
    		bw.write(rec+ "\n");
    	}
   
    		 catch(IOException e){
    	            System.out.println("Error writing file");
    	}
    }
    
    public void closeFile() throws IOException{
    	  try{
              bw.close();
          }
          catch(IOException e){
              System.out.println("Error closing file)");
          }
    }

	
       
}



