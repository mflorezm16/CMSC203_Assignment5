import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TwoDimRaggedArrayUtilityTestStudent {
	
private TwoDimRaggedArrayUtility twoDimRArrUtilA, twoDimRArrUtilB;

	
	@Before
	public void setUp() throws Exception {
		twoDimRArrUtilA = new TwoDimRaggedArrayUtility();
		twoDimRArrUtilB = new TwoDimRaggedArrayUtility();
	}

	@After
	public void tearDown() throws Exception {
		twoDimRArrUtilA = twoDimRArrUtilB = null;
	}
	
	@Test
	public void testReadFile(){
	        try {
	            File testFile = new File("set1.txt");
	            PrintWriter writer = new PrintWriter(testFile);
	            writer.println("1.2 2.3 3.4");
	            writer.println("4.5 5.6");
	            writer.println("7.8 8.9 9.0 10.1");
	            writer.close();
	
	            TwoDimRaggedArrayUtility utility = new TwoDimRaggedArrayUtility();
	            double[][] result = utility.readFile(testFile);
	
	            double[][] expected = {
	                {1.2, 2.3, 3.4},
	                {4.5, 5.6},
	                {7.8, 8.9, 9.0, 10.1}
	            };
	
	            assertEquals(expected.length, result.length, 0.001);
	
	            for (int i = 0; i < expected.length; i++) {
	                assertArrayEquals(expected[i], result[i], 0.001);
	            }
	
	            testFile.delete();
	        } catch (Exception e) {
	            fail("Exception thrown: " + e.getMessage());
	        }
		}
	
	
	@Test
	public void testWriteFile(){
		 try {
		        File testFile = new File("testOutput.txt");
		        double[][] inputData = {
		            {1.2, 2.3, 3.4},
		            {4.5, 5.6},
		            {7.8, 8.9, 9.0, 10.1}
		        };
		
		        TwoDimRaggedArrayUtility.writeToFile(inputData, testFile);
	
		        Scanner scanner = new Scanner(testFile);
		        StringBuilder fileContent = new StringBuilder();
		        while (scanner.hasNextLine()) {
		            fileContent.append(scanner.nextLine().trim()).append("\n");
		        }
		        scanner.close();
		
		        String expectedContent = 
		            "1.2 2.3 3.4\n" +
		            "4.5 5.6\n" +
		            "7.8 8.9 9.0 10.1\n";
		
		        assertEquals(expectedContent.trim(), fileContent.toString().trim());
		        testFile.delete();
		    } catch (Exception e) {
		        fail("Exception thrown: " + e.getMessage());
		    }
	}
	
	@Test
	public void testGetTotal(){
		   double[][] data = {
		            {1.2, 3.4, 5.6},
		            {7.8, 9.0, 0.0},
		            {2.1, 4.3, 6.5}
		        };

		 
		   double total = TwoDimRaggedArrayUtility.getTotal(data);

		   assertEquals(39.9, total, 0.001);
		  }
	
	
	@Test
	public void testGetAverage(){
		 double[][] data = {
		            {1.2, 3.4, 5.6},
		            {7.8, 9.0, 0.0},
		            {2.1, 4.3, 6.5}
		        };

		   double average = TwoDimRaggedArrayUtility.getAverage(data);

		   assertEquals(4.433, average, 0.001);	
		   }
	
	@Test
	public void getRowTotal(){
		 double[][] data = {
		            {1.2, 3.4, 5.6},
		            {7.8, 9.0, 0.0},
		            {2.1, 4.3, 6.5}
		        };

		   double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 1);

		   assertEquals(16.8, rowTotal, 0.001);	
		   }
	
	@Test
	public void getColumnTotal(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };

	   double columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 0);

	   assertEquals(11.1, columnTotal,0.001);		
	   }
	
	@Test
	public void testGetHighestInRow(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double highestInRow = TwoDimRaggedArrayUtility.getHighestInRow(data, 0);
		   assertEquals(5.6, highestInRow, 0.001);

	}
	
	@Test
	public void testGetHighestInRowIndex(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double highestInRowIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0);
		   assertEquals(2, highestInRowIndex, 0.001);
	}
	
	@Test
	public void testGetLowestInRow(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double lowestInRow = TwoDimRaggedArrayUtility.getLowestInRow(data, 1);
		   assertEquals(0.0, lowestInRow, 0.001);
	}
	
	@Test
	public void testGetLowestInRowIndex(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double lowestInRowIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1);
		   assertEquals(2, lowestInRowIndex, 0.001);
	}
	
	@Test
	public void testGetHighestInColumn(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double highestInColumn = TwoDimRaggedArrayUtility.getHighestInColumn(data, 0);
		   assertEquals(7.8, highestInColumn, 0.001);
	}
	
	@Test
	public void testGetHighestInColumnIndex(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double highestInColumnIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0);
		   assertEquals(1, highestInColumnIndex, 0.001);
	}
	
	@Test
	public void testGetLowestInColumn(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double lowestInColumn = TwoDimRaggedArrayUtility.getLowestInColumn(data, 1);
		   assertEquals(3.4, lowestInColumn, 0.001);
	}
	
	@Test
	public void testGetLowestInColumnIndex(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double lowestInColumnIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1);
		   assertEquals(0, lowestInColumnIndex, 0.001);
	}
	
	@Test
	public void testGetHighestInArray(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double highestInArray = TwoDimRaggedArrayUtility.getHighestInArray(data);
		   assertEquals(9.0, highestInArray, 0.001);
	}
	
	@Test
	public void testGetLowestInArray(){
		double[][] data = {
	            {1.2, 3.4, 5.6},
	            {7.8, 9.0, 0.0},
	            {2.1, 4.3, 6.5}
	        };
		   double lowestInArray = TwoDimRaggedArrayUtility.getLowestInArray(data);
		   assertEquals(0.0, lowestInArray, 0.001);
	}
	
	
	

}
