
public class HolidayBonus extends Object{
	
	HolidayBonus(){
		super();
	}
	 
// 1.	Method calculateHolidayBonus – 
//  pass in a two-dimensional ragged array of doubles. 
//	It will return an array of doubles which represents the holiday bonuses 
//	for each of the stores in the district. The first entry in the returned 
//	array [0] will represent the holiday bonus for the store at [0] in the 
//  two-dimensional ragged array of doubles. You will be using methods from 
//	the TwoDimRaggedArrayUtility when needed.
	
	public static double[] calculateHolidayBonus(double[][] data) {
	    double[] result = new double[data.length];
	    int numColumns = 0;
	    for (double[] row : data) {
	        numColumns = Math.max(numColumns, row.length);
	    }
	    for (int col = 0; col < numColumns; col++) {
	        Double highestValue = null;
	        Double lowestValue = null;
	        for (double[] row : data) {
	            if (col < row.length) {
	                if (highestValue == null || row[col] > highestValue) {
	                    highestValue = row[col];
	                }
	                if (lowestValue == null || row[col] < lowestValue) {
	                    lowestValue = row[col];
	                }
	            }
	        }
	for (int row = 0; row < data.length; row++) {
	            if (col < data[row].length) {
	                if (data[row][col] == highestValue) {
	                    result[row] += 5000;
	                } else if (data[row][col] == lowestValue) {
	                    result[row] += 1000;
	                } else {
	                    result[row] += 2000;
	                }
	            }
	        }
	    }
	    return result;
	}
	
	
	
// 2.	Method calculateTotalHolidayBonus – 
// pass in a two-dimensional ragged array of doubles. It will return a double which represents the total of all Holiday Bonuses for the District. You will be using methods from the TwoDimRaggedArrayUtility when needed.

	 static double calculateTotalHolidayBonus(double[][] data) {
		 double[] bonuses = calculateHolidayBonus(data);
			double result = 0.0;
			for(int i = 0; i < bonuses.length; i++) {
				double bonus = bonuses[i];
				result += bonus;
			}
			return result;
	 }

}
