import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://stackoverflow.com/questions/28563684/filenotfoundexception-and-file-exists
 * https://stackoverflow.com/questions/10657315/git-merge-left-head-marks-in-my-files
 */
public class ReadDino {
    
    File file;
    
    public static void main(String[] args) {
        ReadDino readDino = new ReadDino();
        readDino.setUp();
    }
    
    public void setUp() {
        //Create array of array of strings
        //{{stat,stat,stat},{stat,stat,stat},{stat,stat,stat}}
        ArrayList<ArrayList<String>> arrayOfDinos = new ArrayList<>();
        
        String fileName = "DinoTable.txt";
        URL url = getClass().getResource("/resources/" + fileName);
        //URL url = readDino.getClass().getResource("/resources/DinoTable.csv");
        //URL url = readDino.getClass().getResource("DinoTable.xlsx");
        
        file = new File(url.getPath());
        
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println("\n");
        
        //Read file
        arrayOfDinos = processData(arrayOfDinos);
        //print file
        printArray(arrayOfDinos);
    }
    
    private ArrayList<ArrayList<String>> processData(ArrayList<ArrayList<String>> arrayOfDinos) {
        try {
            Scanner input = new Scanner(file);
            
            //boolean .hasNextLine() returns true if there is another line
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] lineOfStats = line.split(",");
                //Creates a single ArrayList type string
                ArrayList<String> singleDino = new ArrayList<String>();
                
                //goes through a single line similar to column
                //s is the individual stat and lineOfStat is the entire row
                //TODO: how do the for loop work
                for (String s : lineOfStats) {
                    //Adds individual stats to a ArrayList of Strings
                    singleDino.add(s);
                }
                //Adds an entire row to the ArrayList
                arrayOfDinos.add(singleDino);
            }
            
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return arrayOfDinos;
    }
    
    //Print the dinosaur results
    private void printArray(ArrayList<ArrayList<String>> arrayOfDinos) {
        
        //print first line with Dinos and their stats
        //how is the for loop working if Dino is blank
        for (ArrayList<String> dino : arrayOfDinos) {
            for (String s : dino) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
    }
    
    public String[] getDinoData(String name) {
        String[] dinoData = new String[]{};
        return dinoData;
    }
}