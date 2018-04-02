import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadDino
{
	public static void main (String []args) 
	{
		//Create array of array of strings
		//{{stat,stat,stat},{stat,stat,stat},{stat,stat,stat}}
		ArrayList<ArrayList<String>> arrayOfDinos = new ArrayList<ArrayList<String>>();

		//Open csv file
		String fileName = "DinoTable.csv";
		File file = new File(fileName);
		ReadDino readDino = new ReadDino();

		//Read file
		try {
			Scanner input = new Scanner(file);
			arrayOfDinos = readDino.processData(input, arrayOfDinos);
			input.close();

		}catch (FileNotFoundException e) {

		}
	}
	
	private ArrayList<ArrayList<String>> processData(Scanner input,  ArrayList<ArrayList<String>> arrayOfDinos)
	{
		int index = 0;
		while(input.hasNext())
		{
			String line = input.next();
			String[] stats = line.split(",");
			//goes through similar to column
			for(String s : stats)
			{
				arrayOfDinos.get(index).add(s);
			}
			//update row or dinosaur we're on
			index++;
		}
		return arrayOfDinos;

	}

}