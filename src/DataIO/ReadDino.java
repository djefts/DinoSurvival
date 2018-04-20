import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://stackoverflow.com/questions/28563684/filenotfoundexception-and-file-exists
 * https://stackoverflow.com/questions/10657315/git-merge-left-head-marks-in-my-files
 */
public class ReadDino
{
		
	public static void main (String []args) 
	{
		//Create array of array of strings
		//{{stat,stat,stat},{stat,stat,stat},{stat,stat,stat}}
		ArrayList<ArrayList<String>> arrayOfDinos = new ArrayList<>();
		
		ReadDino readDino = new ReadDino();
		String fileName = "DinoTable.txt";
        URL url = readDino.getClass().getResource("/resources/"+fileName);
        //URL url = readDino.getClass().getResource("/resources/DinoTable.csv");
        //URL url = readDino.getClass().getResource("DinoTable.xlsx");
        
        File file = new File(url.getPath());
        
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println("\n\n");
  
		//Read file
		try {
			Scanner input = new Scanner(file);
			arrayOfDinos = readDino.processData(input, arrayOfDinos);
			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("\n\nFile not found");
		}
		
		readDino.printArray(arrayOfDinos);
	}

	private ArrayList<ArrayList<String>> processData(Scanner input,  ArrayList<ArrayList<String>> arrayOfDinos)
	{
		//boolean .hasNextLine() returns true if there is another line
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			String[] lineOfStats = line.split(",");
			//Creates a single ArrayList type string
			ArrayList<String> singleDino = new ArrayList<String>();
			
			
			//goes through a single line similar to column
			//s is the individual stat and lineOfStat is the entire row
			//TODO: how do the for loop work
			for(String s : lineOfStats)
			{
				//Adds individual stats to a ArrayList of Strings
				singleDino.add(s); 			
			}
			//Adds an entire row to the ArrayList
			arrayOfDinos.add(singleDino);
		}
		return arrayOfDinos;
	}
	//Print the dinosaur results
	private void printArray(ArrayList<ArrayList<String>> arrayOfDinos)
	{
		
		//print first line with Dinos and their stats
		//how is the for loop working if Dino is blank
		for (ArrayList<String> dino : arrayOfDinos  )
		{	
			for (String s : dino)
			{
				System.out.print(s + "\t");
			}
			System.out.println();
		}
	}
}