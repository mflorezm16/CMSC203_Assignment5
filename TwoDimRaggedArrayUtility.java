
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public final class TwoDimRaggedArrayUtility extends Object {
	
	
	public TwoDimRaggedArrayUtility() {
		super();
	}
	// 1.	Method readFile – pass in a file and return a two-dimensional ragged array of doubles.
	public static double[][] readFile(File file) {
		ArrayList <double[]> list = new ArrayList<>();
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(keyboard.hasNextLine()) {
			String line = keyboard.nextLine();
			String[] items = line.split(" ");
			double[] row = new double[items.length];
			for(int i = 0; i < items.length; i++) {
				row[i] = Double.parseDouble(items[i]);
			}
			list.add(row);
		}
		keyboard.close();
		double[][] result = new double[list.size()][];
		for(int j = 0; j < list.size(); j++) {
			result[j] = list.get(j);
		}
		return result;
	}
	// 2.	Method writeToFile – 
	//pass in a two-dimensional ragged array of doubles and a file; and writes the ragged array into the file. Each row is on a separate line and each double is separated by a space. 

	public static void writeToFile(double[][] arr, File file) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	        for (int i = 0; i < arr.length; i++) {
	            StringBuilder sb = new StringBuilder();
	            double[] row = arr[i];
	            for (int j = 0; j < row.length; j++) {
	                sb.append(row[j]);
	                if (j < row.length - 1) {
	                    sb.append(" "); // Add a space between numbers
	                }
	            }
	            writer.write(sb.toString()); 
	            writer.newLine(); 
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	//3.	Method getTotal – 
	//pass in a two-dimensional ragged array of doubles and returns the total of the elements in the array.

	public static double getTotal(double[][]arr) {
		double total = 0.0;
		for(int i = 0; i < arr.length; i ++) {
			for(int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
		}
		return total;
	}
	// 4.	Method getAverage – 
//	pass in a two-dimensional ragged array of doubles and returns the average of the elements in the array (total/num of elements).

	public static double getAverage(double[][] arr) {
		double total = 0.0;
		int numOfObjects = 0;
		for(int i = 0; i < arr.length; i ++) {
			for(int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
				numOfObjects += 1;
			}
		}
		double average = total/numOfObjects;
		return average;
	}
	// 5.	Method getRowTotal – 
	//pass in a two-dimensional ragged array of doubles and a row index and returns the total of that row. Row index 0 is the first row in the array.

	public static double getRowTotal(double[][] arr, int rowIndex) {
		double rowTotal = 0.0;
			for(int j = 0; j < arr[rowIndex].length; j++) {
				rowTotal += arr[rowIndex][j];
			}
		return rowTotal;
	}
	//6.	Method getColumnTotal - 
	//pass in a two-dimensional ragged array of doubles and a column index and returns the total of that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method.

	public static double getColumnTotal(double[][] arr, int columnIndex) {
		double columnTotal = 0.0;
		for(int j = 0; j < arr.length; j++) {
			columnTotal += arr[j][columnIndex];
		}
		return columnTotal;
	}
	// 7.	Method getHighestInRow - 
	//pass in a two-dimensional ragged array of doubles and a row index and returns the largest element in that row. Row index 0 is the first row in the array.

	public static double getHighestInRow(double[][] arr, int rowIndex) {
		double highest = Double.MIN_VALUE;
		for(int i = 0; i < arr[rowIndex].length; i++) {
			if(highest < arr[rowIndex][i]) {
				highest = arr[rowIndex][i];
			}
		}
		return highest;
	}
	
	// 8.	Method getHighestInRowIndex - 
	//pass in a two-dimensional ragged array of doubles and a row index and returns the index of the largest element in that row. Row index 0 is the first row in the array.

	public static int getHighestInRowIndex(double[][] arr, int rowIndex) {
		double highest = Double.MIN_VALUE;
		int resultIndex = -1;
		for(int i = 0; i < arr[rowIndex].length; i++) {
			if(highest < arr[rowIndex][i]) {
				highest = arr[rowIndex][i];
				resultIndex = i;
			}
		}
		return resultIndex;
	}
	
	//9.	Method getLowestInRow - 
	//a two-dimensional ragged array of doubles and a row index and returns the smallest element in that row. Row index 0 is the first row in the array.

	public static double getLowestInRow(double[][] arr, int rowIndex) {
		double lowest = Double.MAX_VALUE;
		for(int i = 0; i < arr[rowIndex].length; i++) {
			if(lowest > arr[rowIndex][i]) {
				lowest = arr[rowIndex][i];
			}
		}
		return lowest;
	}
	
	//10.	Method getLowestInRowIndex - 
	//a two-dimensional ragged array of doubles and a row index and returns the index of the smallest element in that row. Row index 0 is the first row in the array.

	public static int getLowestInRowIndex(double[][] arr, int rowIndex) {
		double lowest = Double.MAX_VALUE;
		int resultIndex = -1;
		for(int i = 0; i < arr[rowIndex].length; i++) {
			if(lowest > arr[rowIndex][i]) {
				lowest = arr[rowIndex][i];
				resultIndex = i;
			}
		}
		return resultIndex;
	}
	
	// 11.	Method getHighestInColumn - 
	//pass in a two-dimensional ragged array of doubles and a column index and returns the largest element in that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method.

	public static double getHighestInColumn(double[][] arr, int columnIndex) {
		double highest = Double.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(highest < arr[i][columnIndex]) {
				highest = arr[i][columnIndex];
			}
		}
		return highest;
	}
	// 12.	Method getHighestInColumnIndex - 
		// pass in a two-dimensional ragged array of doubles and a column index and returns the index of the largest element in that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method.

	public static int getHighestInColumnIndex(double[][] arr, int columnIndex) {
		double highest = Double.MIN_VALUE;
		int resultIndex = -1;
		for(int i = 0; i < arr.length; i++) {
			if(highest < arr[i][columnIndex]) {
				highest = arr[i][columnIndex];
				resultIndex = i;
			}
		}
		return resultIndex;
	}
	
	// 13.	Method getLowestInColumn - pass in 
		//a two-dimensional ragged array of doubles and a column index and returns the smallest element in that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method.

	public static double getLowestInColumn(double[][] arr, int columnIndex) {
		double lowest = Double.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(lowest > arr[i][columnIndex]) {
				lowest = arr[i][columnIndex];
			}
		}
		return lowest;
	}
	
	// 14.	Method getLowestInColumnIndex - 
		// pass in a two-dimensional ragged array of doubles and a column index and returns the index of the smallest element in that column. Column index 0 is the first column in the array. If a row doesn’t contain that column, it is not an error, that row will not participate in this method.

	public static int getLowestInColumnIndex(double[][] arr, int columnIndex) {
		double lowest = Double.MAX_VALUE;
		int resultIndex = -1;
		for(int i = 0; i < arr.length; i++) {
			if(lowest > arr[i][columnIndex]) {
				lowest = arr[i][columnIndex];
				resultIndex = i;
			}
		}
		return resultIndex;		
	}
	
	//15.	Method getHighestInArray - 
		//pass in a two-dimensional ragged array of doubles and returns the largest element in the array.

	public static double getHighestInArray(double[][] arr) {
		double highest = Double.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(highest < arr[i][j]) {
					highest = arr[i][j];
				}
			}
		}
		
		return highest;
	}
	
	// 16.	Method getLowestInArray - 
		// pass in a two-dimensional ragged array of doubles and returns the smallest element in the array.

	public static double getLowestInArray(double[][] arr) {
		double lowest = Double.MAX_VALUE;
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				if(lowest > arr[row][col]) {
					lowest = arr[row][col];
				}
			}
		}
		
		return lowest;
	}
	
	

}
