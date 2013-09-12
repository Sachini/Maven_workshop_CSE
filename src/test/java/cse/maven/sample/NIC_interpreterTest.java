package cse.maven.sample;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cse.maven.sample.exception.InvalidNicPropException;
import java.util.Date;
import static org.testng.Assert.assertEquals;

@Test
public class NIC_interpreterTest {

	NIC_interpreter bmiCalculator;
		
	@BeforeClass
	public void setUp() {
		bmiCalculator = new NIC_interpreter();
	}
	
	@Test
	public void createBmiTest1() throws InvalidNicPropException {
		NicProp bmiProp = bmiCalculator.createNicProp("916000979v");
                assertEquals(bmiProp.getNicInt(), 916000979);
	}
	
	@Test(expectedExceptions = InvalidNicPropException.class)
	public void createBmiTest2() throws InvalidNicPropException {
		NicProp bmiProp = bmiCalculator.createNicProp("916sfs789v");	 
	}
	
	@Test
	public void testCalculate1() throws InvalidNicPropException {
		NicProp bmiProp = new NicProp("916000979v");
		Date bmi = bmiCalculator.calculateDate(bmiProp);
		assertEquals(bmi, 22.145329f);		
	}
	
	@Test(expectedExceptions = InvalidNicPropException.class)
	public void testCalculate2() throws InvalidNicPropException {
		NicProp bmiProp = new NicProp("91a000979v");
		bmiCalculator.getGender(bmiProp);		
	}
	
}
