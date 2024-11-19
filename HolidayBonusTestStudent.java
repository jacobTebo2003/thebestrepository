/* 

 * Class: CMSC203  

 * Instructor: Prof. Grigoriy Grinberg 

 * Description: Test class for HolidayBonus.java

 * Due: 11/21/2024 

 * Platform/compiler: Eclipse 

 * I pledge that I have completed the programming assignment independently. 

*  I have not copied the code from a student or any source.  

*  I have not given my code to any student. 

*  Print your Name here: Jacob Tebo 

*/ 

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {

    // This will run before each test method.
    @BeforeEach
    void setUp() throws Exception {
    
    }

    // This will run after each test method.
    @AfterEach
    void tearDown() throws Exception {
        
    }

    @Test
    public void testCalculateHolidayBonus_validData() {
        // Test case where there are multiple stores with valid sales
        double[][] salesData = {
            {1000, 2000, 3000},
            {1500, 2500, 3500},
            {2000, 3000, 4000}
        };

        // Expected bonuses for the stores
        double[] expectedBonuses = {3000, 6000, 15000};

        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals(expectedBonuses, actualBonuses, "The bonuses should be correctly calculated for each store.");
    }

    @Test
    public void testCalculateHolidayBonus_singleStorePositiveSales() {
        // Test case where only one store has positive sales for a given category
        double[][] salesData = {
            {0, 5000, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        // Expected bonuses: Only the first store gets the max bonus (5000)
        double[] expectedBonuses = {5000, 0, 0};

        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals(expectedBonuses, actualBonuses, "Only the store with positive sales should get the max bonus.");
    }

    @Test
    public void testCalculateHolidayBonus_allZeroOrNegativeSales() {
        // Test case where all sales are zero or negative, meaning no bonus should be calculated
        double[][] salesData = {
            {0, -5000, -100},
            {0, -2000, -100},
            {0, -400, -500}
        };

        // Expected bonuses: All stores should have 0 as they don't qualify for any bonus
        double[] expectedBonuses = {0, 0, 0};

        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals(expectedBonuses, actualBonuses, "Stores with zero or negative sales should get no bonus.");
    }

    @Test
    public void testCalculateHolidayBonus_nullData() {
        // Test case where the input data is null
        double[][] salesData = null;

        // Expecting IllegalArgumentException for null sales data
        assertThrows(IllegalArgumentException.class, () -> {
            HolidayBonus.calculateHolidayBonus(salesData);
        }, "Null sales data should throw IllegalArgumentException.");
    }

    @Test
    public void testCalculateHolidayBonus_emptyData() {
        // Test case where the input data is empty
        double[][] salesData = new double[0][0];

        // Expecting IllegalArgumentException for empty sales data
        assertThrows(IllegalArgumentException.class, () -> {
            HolidayBonus.calculateHolidayBonus(salesData);
        }, "Empty sales data should throw IllegalArgumentException.");
    }

    @Test
    public void testCalculateTotalHolidayBonus_validData() {
        // Test case where the total holiday bonus is calculated correctly
        double[][] salesData = {
            {1000, 2000, 3000},
            {1500, 2500, 3500},
            {2000, 3000, 4000}
        };

        // The expected total bonus is the sum of individual bonuses
        double expectedTotalBonus = 24000.0;

        double actualTotalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);

        assertEquals(expectedTotalBonus, actualTotalBonus, 0.01, "The total holiday bonus should be correctly calculated.");
    }


}
