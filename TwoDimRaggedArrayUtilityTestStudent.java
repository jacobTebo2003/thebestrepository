/* 

 * Class: CMSC203  

 * Instructor: Prof. Grigoriy Grinberg 

 * Description: Test class for TwoDimArrayUtility.java 

 * Due: 11/21/2024 

 * Platform/compiler: Eclipse 

 * I pledge that I have completed the programming assignment independently. 

*  I have not copied the code from a student or any source.  

*  I have not given my code to any student. 

*  Print your Name here: Jacob Tebo 

*/ 

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

	private static final String TEST_FILE_PATH = "test.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		
		// Clean up after tests 
        File outputFile = new File(OUTPUT_FILE_PATH);
        if (outputFile.exists()) {
            outputFile.delete();
        }
       
	}
	
	@Test
    public void testReadFile_validData() throws IOException {
        // Prepare a test file with valid data
        File inputFile = new File(TEST_FILE_PATH);
        try (PrintWriter writer = new PrintWriter(inputFile)) {
            writer.println("1.0 2.0 3.0");
            writer.println("4.0 5.0");
            writer.println("6.0 7.0 8.0 9.0");
        }

        double[][] expectedArray = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        // Call the readFile method
        double[][] actualArray = TwoDimRaggedArrayUtility.readFile(inputFile);

        // Assert that the result matches the expected array
        assertNotNull(actualArray);
        assertEquals(expectedArray.length, actualArray.length);
        for (int i = 0; i < expectedArray.length; i++) {
            assertArrayEquals(expectedArray[i], actualArray[i]);
        }

        // Clean up
        inputFile.delete();
    }
	
    @Test
    public void testReadFile_invalidFile() {
        // Test invalid file path
        File invalidFile = new File("invalid.txt");
        double[][] result = TwoDimRaggedArrayUtility.readFile(invalidFile);

        assertNull(result, "The result should be null for an invalid file.");
    }


	@Test
    public void testWriteToFile() throws FileNotFoundException {
        // Prepare test data
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        File outputFile = new File(OUTPUT_FILE_PATH);

        // Write data to file
        TwoDimRaggedArrayUtility.writeToFile(data, outputFile);

        // Verify that the file was created and contains expected data
        assertTrue(outputFile.exists(), "The output file should exist.");

        // Read the file contents and verify
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line = reader.readLine();
            assertEquals("1.0 2.0 3.0", line);
            line = reader.readLine();
            assertEquals("4.0 5.0", line);
            line = reader.readLine();
            assertEquals("6.0 7.0 8.0 9.0", line);
        } catch (IOException e) {
            fail("IOException while reading the file: " + e.getMessage());
        }

        // Clean up
        outputFile.delete();
    }

    @Test
    public void testGetTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        double expectedTotal = 1.0 + 2.0 + 3.0 + 4.0 + 5.0 + 6.0 + 7.0 + 8.0 + 9.0;
        double actualTotal = TwoDimRaggedArrayUtility.getTotal(data);

        assertEquals(expectedTotal, actualTotal, "Total should be correct.");
    }

    @Test
    public void testGetAverage() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        double expectedAverage = (1.0 + 2.0 + 3.0 + 4.0 + 5.0 + 6.0 + 7.0 + 8.0 + 9.0) / 9;
        double actualAverage = TwoDimRaggedArrayUtility.getAverage(data);

        assertEquals(expectedAverage, actualAverage, "Average should be correct.");
    }

    @Test
    public void testGetRowTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        double expectedRowTotal = 1.0 + 2.0 + 3.0;
        double actualRowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 0);

        assertEquals(expectedRowTotal, actualRowTotal, "Row total should be correct.");
    }

    @Test
    public void testGetColumnTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        double expectedColumnTotal = 1.0 + 4.0 + 6.0; // Column 0
        double actualColumnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 0);

        assertEquals(expectedColumnTotal, actualColumnTotal, "Column total should be correct.");
    }

    @Test
    public void testGetHighestInRow() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        double expectedHighest = 3.0;
        double actualHighest = TwoDimRaggedArrayUtility.getHighestInRow(data, 0);

        assertEquals(expectedHighest, actualHighest, "The highest value in row should be correct.");
    }

    @Test
    public void testGetHighestInColumn() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        double expectedHighest = 6.0; // Column 0
        double actualHighest = TwoDimRaggedArrayUtility.getHighestInColumn(data, 0);

        assertEquals(expectedHighest, actualHighest, "The highest value in column should be correct.");
    }

    @Test
    public void testGetLowestInRow() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        double expectedLowest = 1.0;
        double actualLowest = TwoDimRaggedArrayUtility.getLowestInRow(data, 0);

        assertEquals(expectedLowest, actualLowest, "The lowest value in row should be correct.");
    }

    @Test
    public void testGetLowestInColumn() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };

        double expectedLowest = 1.0; // Column 0
        double actualLowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, 0);

        assertEquals(expectedLowest, actualLowest, "The lowest value in column should be correct.");
    }

}
