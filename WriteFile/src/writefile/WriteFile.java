/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package writefile;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan
 */
public class WriteFile {

    public WriteFile() {
      
   
        String myFile="D:\\itisecurity\\WriteFile\\src\\writefile\\text.txt";
        DataOutputStream dos=null;
        try{
            dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(myFile),128));
            dos.writeChars("nour is here");
            dos.flush();
            System.out.println("file created"+myFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         //To change body of generated methods, choose Tools | Templates.
    
    }
  
   
    
    public static void main(String[] args) {
            WriteFile obj = new WriteFile();
            
        System.out.println("welcome"+obj.toString());
    }
    
}
