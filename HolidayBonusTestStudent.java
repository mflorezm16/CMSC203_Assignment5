import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import utility.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;


public class HolidayBonusTestStudent {
	
	private HolidayBonus holidayBonusA, holidayBonusB;

	private double[][] dataSet1 = { { 16, 4, 2 }, { 8, 10 }, { 6, 14, 12 } };

	
	@Before
	public void setUp() throws Exception {
		holidayBonusA = new HolidayBonus();
		holidayBonusB = new HolidayBonus();
	}

	@After
	public void tearDown() throws Exception {
		holidayBonusA = holidayBonusB = null;
		
		
		
	}
	
	
	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(7000.0, result[0], .001);
			assertEquals(4000.0, result[1], .001);
			assertEquals(11000.0, result[2], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
	}

}
