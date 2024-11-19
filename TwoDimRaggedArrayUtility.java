/* 

 * Class: CMSC203  

 * Instructor: Prof. Grigoriy Grinberg 

 * Description: Includes methods for reading data, and calculating different aspects of a 2d array. 

 * Due: 11/21/2024 

 * Platform/compiler: Eclipse 

 * I pledge that I have completed the programming assignment independently. 

*  I have not copied the code from a student or any source.  

*  I have not given my code to any student. 

*  Print your Name here: Jacob Tebo 

*/ 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtility {
    
    // Constants for maximum rows and columns
    private static final int MAX_ROWS = 10;
    private static final int MAX_COLUMNS = 10;

    // No-arg constructor
    public TwoDimRaggedArrayUtility() 
    {
        System.out.println("Object created.");
    }

    // Method to read file and return a 2D ragged array
    public static double[][] readFile(File file) 
    {
        // Temporary array to hold strings from the file
        String[][] tempArray = new String[MAX_ROWS][MAX_COLUMNS];

        // Check if the file exists and is readable
        if (!file.exists() || !file.canRead()) {
            System.out.println("File not found or not readable.");
            return null;
        }

        // Initialize the line and row count
        String line = "";
        int rowCount = 0;

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Read each line from the file
            while ((line = br.readLine()) != null && rowCount < MAX_ROWS) {
                String[] elements = line.split(" ");
                
                // Ensure we don't exceed the MAX_COLUMNS limit
                for (int i = 0; i < Math.min(elements.length, MAX_COLUMNS); i++) {
                    tempArray[rowCount][i] = elements[i];
                }
                rowCount++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // If no rows were read, return null
        if (rowCount == 0) {
            return null;
        }

        // Create the ragged array based on the number of rows
        double[][] result = new double[rowCount][];

        // Process each row
        for (int i = 0; i < rowCount; i++) {
            // Find the number of valid columns in the current row
            int colCount = 0;
            while (colCount < MAX_COLUMNS && tempArray[i][colCount] != null) {
                colCount++;
            }

            // Create the row with the actual number of columns
            result[i] = new double[colCount];

            // Convert the String values to double and populate the row
            for (int j = 0; j < colCount; j++) {
                try {
                    result[i][j] = Double.parseDouble(tempArray[i][j]);
                } catch (NumberFormatException e) {
                    // Handle invalid number format
                    System.err.println("Invalid number format at row " + i + ", column " + j);
                    return null;  // Or handle it differently if needed
                }
            }
        }

        // Return the populated ragged array
        return result;
    }
    
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
      try(PrintWriter pw = new PrintWriter(outputFile))
      {
    	  for (int row = 0; row < data.length; row++)
    	  {
    		  for (int column = 0; column < data[row].length; column++)
    		  {
    			  pw.print(data[row][column]); //Print each 

    			  if (column < data[row].length - 1) {
                      pw.print(" "); // Separate values by a space
    		  }
    	  }
    	  pw.println();
    	  
      } 
      }catch (FileNotFoundException e)
      {
    	  throw new FileNotFoundException("Output file could not be found: ");
      }
    }
    
    public static double getTotal(double[][] data)
    {
    	double result = 0;
    	
    	for (int row = 0; row < data.length; row++)
    	{
    		for (int column = 0; column < data[row].length; column++)
    		{
    			result += data[row][column];
    		}
    	}
    	
    	if (result == 0) 
    	{
    	   return 0.0;
    	}
    	else
    	{
    	return result;
    	}
    }
    
    public static double getAverage(double[][] data)
    {
    	double result = 0;
    	double count = 0;
    	
    	for (int row = 0; row < data.length; row++)
    	{
    		for (int column = 0; column < data[row].length; column++)
    		{
    			result += data[row][column];
    			count++;
    		}
    	}
    	
    	if (count == 0) 
    	{
    	   return 0.0;
    	}
    	else
    	{
    	   return result/count;
    	}
    	

    }
    
    public static double getRowTotal(double[][] data,
    		 int row)
    {
    	
    	if (row < 0 || row >= data.length) {
            throw new IllegalArgumentException("Invalid row index: " + row);
        }
    	
    	double total = 0;
    	
    	for (int column = 0; column < data[row].length; column++)
    	{
    		total += data[row][column];
    	}
    	
    	
    	return total;
    }
    
    public static double getColumnTotal(double[][] data,
    		 int col)
    {
    	
    	
    	double total = 0;
    	
    	for (int row = 0; row < data.length; row++)
    	{
    		// Check if the current row has the specified column
            if (col < data[row].length) {
                // If the row has the column, add its value to the total
            	total += data[row][col];
            }
    	
    	}
    	
    	return total;
    }
    
    public static double getHighestInRow(double[][] data,
    		 int row)
    {
    	//Check if row is valid
    	if (row < 0 || row >= data.length) {
            throw new IllegalArgumentException("Invalid row index: " + row);
        }
    	
    	 // Check if the row is empty
        if (data[row].length == 0) {
            throw new IllegalArgumentException("Row " + row + " is empty.");
        }
    	
    	double highest = 0;
    	
    	for (int column = 0; column < data[row].length; column++)
    	{
    		
    		if (highest < data[row][column])
    		{
    			highest = data[row][column];
    		}
    	}
    	
    	
    	return highest;
    }
    
    public static int getHighestInRowIndex(double[][] data,
    		 int row)
    {
    	//Check if row is valid
    	if (row < 0 || row >= data.length) {
            throw new IllegalArgumentException("Invalid row index: " + row);
        }
    	
    	 // Check if the row is empty
        if (data[row].length == 0) {
            throw new IllegalArgumentException("Row " + row + " is empty.");
        }
    	
    	int highest = 0;
    	
    	for (int column = 1; column < data[row].length; column++)
    	{
    		
    		if (data[row][highest] < data[row][column])
    		{
    			highest = column;
    		}
    	}
    	
    	return highest;
    }
    
    public static double getLowestInRow(double[][] data,
    		 int row)
    {
    	if(row < 0 || row >= data.length)
    	{
    		throw new IllegalArgumentException("invalid row index");
    	}
    	
    	 // Check if the row is empty
        if (data[row].length == 0) {
            throw new IllegalArgumentException("Row " + row + " is empty.");
        }
        
        
    	double lowest = data[row][0];
    	
    	for(int column = 1; column < data[row].length; column++)
    	{
    		if (data[row][column] < lowest)
    		{
    			lowest = data[row][column];
    		}
    	}
    	
    	return lowest;
    }
    
    public static int getLowestInRowIndex(double[][] data,
    		 int row)
    {
    	if(row < 0 || row >= data.length)
    	{
    		throw new IllegalArgumentException("invalid row index");
    	}
    	
    	int lowest = 0;
    	
    	for (int column = 1; column < data[row].length; column++)
    	{
    		if(data[row][column] < data[row][lowest])
    		{
    			lowest = column;
    		}
    	}
    	
    	return lowest;
    }
    
    public static double getHighestInColumn(double[][] data, int col) {
        // Check if the data array is null or empty
        if (data == null || data.length == 0 || col < 0) {
            throw new IllegalArgumentException("Invalid input data or column index");
        }

        // Initialize 'highest' to a very small value (can also use Double.NEGATIVE_INFINITY)
        double highest = Double.NEGATIVE_INFINITY;

        // Iterate through each row in the data array
        for (int row = 0; row < data.length; row++) {
            // Check if the current row has the specified column index
            if (col < data[row].length) {
                // Compare the current element in the column with the current 'highest'
                if (data[row][col] > highest) {
                    highest = data[row][col];
                }
            }
        }

        // Return the largest element found in the column
        return highest;
    }

    

    public static int getHighestInColumnIndex(double[][] data, int col) {
        // Check if the data array is null or empty or if the column index is invalid
        if (data == null || data.length == 0 || col < 0) {
            throw new IllegalArgumentException("Invalid input data or column index");
        }

        // Initialize variables to track the largest value and its index
        int highestIndex = 0;
        double highestValue = data[0][col];

        // Iterate over each row in the data array
        for (int row = 0; row < data.length; row++) {
            // Check if the current row has the specified column index
            if (col < data[row].length) {
                // Compare the current element in the column with the current highest value
                if (data[row][col] > highestValue) {
                    highestValue = data[row][col];
                    highestIndex = row;  // Update the index of the highest value
                }
            }
        }

        // Return the index of the largest element found in the specified column
        return highestIndex;
    }

    
    public static double getLowestInColumn(double[][] data, int col) {
        // Validate the column index

        // Initialize 'lowest' to NaN, which we will use as a flag to find the first valid positive element in the column
        double lowest = Double.NaN;

        // Iterate over each row in the array
        for (int row = 0; row < data.length; row++) {
            // Check if the row has the specified column index
            if (col < data[row].length) {
                double currentValue = data[row][col];

                // Only consider positive values for the "lowest" comparison (ignore 0 and negative values)
              
                    // If 'lowest' is NaN, this means we haven't found a valid value yet
                    if (Double.isNaN(lowest)) {
                        lowest = currentValue;
                    } else {
                        // Compare the current value with the current 'lowest'
                        if (currentValue < lowest) {
                            lowest = currentValue;
                        }
                    }
                
            }
        }

        // Return the smallest valid positive value found in the column, or NaN if no valid value was found
        return lowest;
    }

    
    
    public static int getLowestInColumnIndex(double[][] data, int col) {
        // Check if data is null or if the column index is out of bounds for any row
        if (data == null || data.length == 0 || col < 0) {
            throw new IllegalArgumentException("Invalid input data or column index");
        }

        // Initialize 'lowest' to a large value so that any positive value will be smaller
        double lowest = Double.MAX_VALUE;
        int lowestIndex = -1;

        // Iterate over each row in the array
        for (int row = 0; row < data.length; row++) {
            // Check if the current row has the specified column index
            if (col < data[row].length) {
                double currentValue = data[row][col];

                // Only consider positive values for the "lowest" comparison (ignore 0 and negative values)
                if (currentValue > 0 && currentValue < lowest) {
                    lowest = currentValue;
                    lowestIndex = row;  // Update the index to the current row
                }
            }
        }

        // If no positive value is found, return -1 to indicate no valid value was found
        return lowestIndex;
    }

    

    public static double getHighestInArray(double[][] data) {
        // Check if the array is null or empty
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("The array is null or empty");
        }

        // Initialize 'highest' to a very small value (can also use Double.MIN_VALUE)
        double highest = data[0][0];

        // Iterate over each row
        for (int row = 0; row < data.length; row++) {
            // Iterate over each column in the row
            for (int col = 0; col < data[row].length; col++) {
                // Compare current element with the highest value
                if (data[row][col] > highest) {
                    highest = data[row][col];
                }
            }
        }

        // Return the largest element found
        return highest;
    }
    
    public static double getLowestInArray(double[][] data) {
        // Check if data is null or empty
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("The array is null or empty");
        }

        // Initialize 'lowest' to a very large value (can also use Double.MAX_VALUE)
        double lowest = data[0][0];

        // Iterate over each row
        for (int row = 0; row < data.length; row++) {
            // Iterate over each column in the row
            for (int col = 0; col < data[row].length; col++) {
                // Compare current element with the lowest value
                if (data[row][col] < lowest) {
                    lowest = data[row][col];
                }
            }
        }

        // Return the smallest element found
        return lowest;
    }


    }




