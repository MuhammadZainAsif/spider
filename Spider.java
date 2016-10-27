/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Zain Asif
 */
public class Spider {

    /**
     * @param args the command line arguments
     */
    
    


    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Map<String,String> mp = new HashMap<>();
        Map<String,String> mp2 = new HashMap<>();
        
         File directory = new File("E:/");
  List<String> files = new ArrayList<>();    // get all the files from a directory
    File[] fList = directory.listFiles();
    int i=0;
    for (File file : fList) {
        if (file.isFile()) {
            String name = file.getName();
            if (name.endsWith(".txt") || name.endsWith(".TXT")){
                StringBuilder sb = new StringBuilder();
                sb.append("E:/");
                sb.append(name);
               
          //  System.out.println(name);
            mp.put(Integer.toString(i),sb.toString());
            i++;
            }
        
    }    
    }
    int ii=0;
    for (Map.Entry<String, String> entry : mp.entrySet())
{
    if(ii<=i){
   // System.out.println(entry.getKey() + "/" + entry.getValue());
    BufferedReader br = new BufferedReader(new FileReader(entry.getValue()));
    //System.out.println(entry.getValue());
try {
    
    String line = br.readLine();
    StringTokenizer t ;
    String word ="";
    while(line!=null){
        t= new StringTokenizer(line);
    while (t.hasMoreTokens()) {
         word = t.nextToken();
         word =word.toLowerCase();
         if(mp2.get(word)==null){
         
         mp2.put(word,Integer.toString(ii));
         
         //System.out.println(word);
         }
         else{
         StringBuilder sb = new StringBuilder();
         
         String s = mp2.get(word);
         sb.append(s);
         sb.append(",");
         sb.append(Integer.toString(ii));
          mp2.put(word,sb.toString());
          //System.out.println(sb.toString());
         }
        
    }
    line = br.readLine();
}
} finally {
    br.close();
}
}
    ii++;
}
    
    System.out.println("Enter the word to search"); 
      Scanner scan = new Scanner(System.in);
   String userinput=scan.nextLine();
    userinput= userinput.toLowerCase();
    // line is not visible here.
        if(mp2.get(userinput)!=null){
        String filesindexes=mp2.get(userinput);
        
        for(String indext :filesindexes.split(",")){
        
        
        System.out.println(" Word found in :"+mp.get(indext)); 
        
        }
        
        }
        else{ System.out.println("There is no filecontaining :"+userinput);}
        
    
    }
}
