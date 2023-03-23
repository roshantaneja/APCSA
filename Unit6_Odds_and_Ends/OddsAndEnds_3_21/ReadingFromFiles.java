
import acm.program.*;
import java.util.*;
import java.io.*;

public class ReadingFromFiles extends ConsoleProgram
{
    public void run()
    { 
        try{
            File file = new File("handout.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                
                println(getFirstWordAlphabetically(words));
                
            }
        } catch(Exception e){
            println("something went wrong");
        }
    }
    
    private String getFirstWordAlphabetically(String[] words){
        String champ = words[0];
        for (int i = 1; i < words.length;i ++){
            if (words[i].compareTo(champ) < 0){
                champ = words[i];
            }
        }
        return (champ);
    }
    
}
