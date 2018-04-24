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
    ArrayList<ArrayList<String>> arrayOfDinos = new ArrayList<>();
    
    public static void main(String[] args) {
        ReadDino readDino = new ReadDino();
        readDino.setUp();
    }
    
    
    public void setUp() {
        
        String fileName = "DinoTable.txt";
        URL url = getClass().getResource("/resources/" + fileName);
        //URL url = readDino.getClass().getResource("/resources/DinoTable.csv");
        //URL url = readDino.getClass().getResource("DinoTable.xlsx");
        
        file = new File(url.getPath());
        
        //testing to make sure the file is where it should be and is found
        /*System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println("\n");*/
        
        //Read file and add it to arrayOfDinos
        processData(arrayOfDinos);
        //print file (testing purposes)
        //printArray(arrayOfDinos);
    }
    
    private void processData(ArrayList<ArrayList<String>> arrayOfDinos) {
        try {
            //Open up the scanner to read the raw data file
            Scanner input = new Scanner(file);
            
            //boolean .hasNextLine() returns true if there is another line
            while (input.hasNextLine()) {
                String line = input.nextLine();             //the current line
                String[] lineOfStats = line.split(",");     //separate the line by commas
                
                //Creates a single ArrayList type string
                ArrayList<String> singleDino = new ArrayList<>();
                
                //goes through a single line similar to column
                //s is the individual stat and lineOfStat is the entire row
                for (String s : lineOfStats) {
                    //Adds individual stats to each spot of singleDino
                    singleDino.add(s);
                }
                //Add singleDino to the full array list
                arrayOfDinos.add(singleDino);
            }
            
            //close the scanner when done :)
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    //Print the dinosaur results
    private void printArray(ArrayList<ArrayList<String>> arrayOfDinos) {
        
        //print first line with Dinos and their stats
        for (ArrayList<String> dino : arrayOfDinos) {
            for (String s : dino) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     *
     * @param name name of the dinosaur asked for
     * @return ArrayList<String> for name dinosaur
     */
    public ArrayList<String> getDinoData(String name) {
        setUp();
        for (int i = 1; i<arrayOfDinos.size(); i++) {
            if(arrayOfDinos.get(i).get(0).equals(name)) {
                return arrayOfDinos.get(i);
            }
        }
        System.out.println("Did you spell the name right?");
        return null;
    }
}