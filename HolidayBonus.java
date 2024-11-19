/* 

 * Class: CMSC203  

 * Instructor: Prof. Grigoriy Grinberg 

 * Description: Calculates the holiday bonus for each store in the district and the total of all the bonuses.

 * Due: 11/21/2024 

 * Platform/compiler: Eclipse 

 * I pledge that I have completed the programming assignment independently. 

*  I have not copied the code from a student or any source.  

*  I have not given my code to any student. 

*  Print your Name here: Jacob Tebo 

*/ 

public class HolidayBonus {
	
	 public HolidayBonus() {
	        
	        
	    }
	 
     // Constants for bonus amounts
     private static final double MAX_SALES_BONUS = 5000;
     private static final double MIN_SALES_BONUS = 1000;
     private static final double OTHER_SALES_BONUS = 2000;
    
        // Method to calculate the total holiday bonus for all stores
        public static double calculateTotalHolidayBonus(double[][] sales) {
            // Call calculateHolidayBonus to get the individual store bonuses
            double[] storeBonuses = calculateHolidayBonus(sales);

            // Calculate and return the total of all store bonuses
            double totalBonus = 0;
            for (double bonus : storeBonuses) {
                totalBonus += bonus;
            }
            return totalBonus;
        }
 

	public static double[] calculateHolidayBonus(double[][] sales) {
		 // Validate the input sales
        if (sales == null || sales.length == 0) {
            throw new IllegalArgumentException("The sales sales is empty or null.");
        }

        // Initialize an array to hold the bonus for each store
        double[] bonuses = new double[sales.length];

        // Iterate through each category (i.e., each column)
        for (int col = 0; col < getMaxColumns(sales); col++) {
            // Identify the highest and lowest sales for the category
            double highestSales = Double.NEGATIVE_INFINITY;
            double lowestSales = Double.POSITIVE_INFINITY;
            int highestStore = -1;
            int lowestStore = -1;
            boolean allZeroOrNegative = true;
            int validStores = 0;  // To track if there is more than one valid store in the column

            // Find the highest and lowest sales values and their respective stores
            for (int row = 0; row < sales.length; row++) {
                if (sales[row].length > col && sales[row][col] > 0) {  // Only consider valid sales (greater than zero)
                    allZeroOrNegative = false;
                    validStores++;
                    if (sales[row][col] > highestSales) {
                        highestSales = sales[row][col];
                        highestStore = row;
                    }
                    if (sales[row][col] < lowestSales) {
                        lowestSales = sales[row][col];
                        lowestStore = row;
                    }
                }
            }

            // If all sales are zero or negative, skip the column, no bonuses
            if (allZeroOrNegative) {
                continue;
            }

            // If there is only one valid store with positive sales in the column, they get $5000
            if (validStores == 1) {
                for (int row = 0; row < sales.length; row++) {
                    if (sales[row].length > col && sales[row][col] > 0) {
                        bonuses[row] += MAX_SALES_BONUS;
                    }
                }
                continue; // Skip the rest of the logic for this column
            }

            // Iterate through each store and calculate bonuses
            for (int row = 0; row < sales.length; row++) {
                if (sales[row].length > col && sales[row][col] > 0) {  // Only consider stores with positive sales
                    // Assign the bonuses based on sales comparison
                    if (sales[row][col] == highestSales) {
                        bonuses[row] += MAX_SALES_BONUS;  // Store with highest sales
                    } else if (sales[row][col] == lowestSales) {
                        bonuses[row] += MIN_SALES_BONUS;  // Store with lowest sales
                    } else {
                        bonuses[row] += OTHER_SALES_BONUS;  // Other stores
                    }
                }
            }
        }

        return bonuses;
	}

	static int getMaxColumns(double[][] sales) {
		   int maxColumns = 0;
           for (int row = 0; row < sales.length; row++) {
               if (sales[row].length > maxColumns) {
                   maxColumns = sales[row].length;
               }
           }
           return maxColumns;
	}



	
}
