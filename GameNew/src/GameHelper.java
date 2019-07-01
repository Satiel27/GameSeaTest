
import java.io.*;
import java.util.*;

public class GameHelper {
	
	private static final String alphabet = "abcdefg";
	private int gritLenght = 7;
	private int gridSize = 49;
	private int [] grid = new int[gridSize];
	private int comCount = 0;
	
	public String getUserInput (String prompt) {
		String imputLine = null;
		System.out.print(prompt + " ");
		
		try {
			BufferedReader is = new BufferedReader (new InputStreamReader(System.in));
				imputLine = is.readLine();
				
				if (imputLine.length()==0) return null;
			} 
			catch (IOException e) {
				System.out.println("IOException: " + e);
			}
			
			return imputLine.toLowerCase();	
	}
	
	public ArrayList<String> placeDotCom(int comSize) {
	
		ArrayList<String> alphaCells = new ArrayList<String>();
		String [] alphacoords = new String [comSize];
		String temp = null;
		int [] coords = new int[comSize];
		int attempts = 0;
		boolean success = false;
		int location = 0;
		
		comCount++;
		int incr = 1;
		if ((comCount % 2) == 1) {
			incr = gritLenght;
		}
		
		while (!success & attempts++ < 200) {
			location = (int) (Math.random() * gridSize);
			//System.out.println("Пробуем " + location);
			int x = 0;
			success = true;
			
			while (success && x < comSize) {
				if (grid[location] == 0) {
					coords[x++] = location;
					location += incr;
					if (location >= gridSize) {
						success = false;
					}
					if (x>0 && (location % gritLenght) == 0) {
						success = false;
					} else {
						//System.out.println("используется " + location);
						success = false;
					}
				}
			}
			
			//int x = 0;
			int row = 0;
			int column =0;
			//System.out.println("\n");
			
			while (x < comSize) {
				grid[coords[x]] = 1;
				row = (int) (coords[x]) / gritLenght;
				column = coords[x] % gritLenght;
				temp = String.valueOf(alphabet.charAt(row));
				
				alphaCells.add(temp.concat(Integer.toString(row)));
				x++;
				
				//System.out.print(" coodr" + x + " =" + alphaCells.get(x-1));
			}
			
			//System.out.println("\n");
			
		}
		
		return alphaCells;
	}
	
	
	
}
