import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sun.security.util.Length;

public class ReadDino
{
	public static void main (String []args) 
	{
		//Create array of array of strings
		//{{stat,stat,stat},{stat,stat,stat},{stat,stat,stat}}
		ArrayList<ArrayList<String>> arrayOfDinos = new ArrayList<>();

		//Open csv file
		//		String fileName = "DinoTable.csv";
		String fileName = "DinoTable.txt";
		//String fileName = "/resources/DinoTable.txt";
		File file = new File(fileName);
		ReadDino readDino = new ReadDino();

		//Read file
		try {
			Scanner input = new Scanner(file);
			arrayOfDinos = readDino.processData(input, arrayOfDinos);
			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("Apparently the file wasn't found");
		}
		
		//readDino.printArray(arrayOfDinos);
	}

	private ArrayList<ArrayList<String>> processData(Scanner input,  ArrayList<ArrayList<String>> arrayOfDinos)
	{
		int index = 0;
		int totalColumns = 0;
		while(input.hasNext())
		{
			String line = input.next();
			String[] stats = line.split(",");
			//goes through similar to column
			for(String s : stats)
			{
				arrayOfDinos.get(index).add(s);
				totalColumns++;
			}
			//update row or dinosaur we're on
			index++;
		}
		return arrayOfDinos;

	}
	private void printArray(ArrayList<ArrayList<String>> arrayOfDinos)
	{
		//prints first row
		for (int i = 0; i < 14; i++ )
		{
			System.out.println(arrayOfDinos.get(i));
		}
		//print Dinos with their stats
		for (int row = 1; row < 12; row++ )
		{
			
			for (int column = 0; column < 14; column++ )
			{
				System.out.println(arrayOfDinos.get(row).get(column));
			}
		}

		return;
	}

}