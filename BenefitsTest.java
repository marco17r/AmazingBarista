package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

//import model.BenefitsMap;
import model.Benefit;

//test case for the Benefit and BenefitsMap classes
public class BenefitsTest
{
	Benefit testBenefit0, testBenefit1, testBenefit2, testBenefit3, testBenefit4;
	int testBenefitType0 = 0;
	double testBenefitPercentage0 = .05;
	int testBenefitType1 = 1;
	double testBenefitPercentage1 = .10;
	int testBenefitType2 = 2;
	double testBenefitPercentage2 = .15;
	
	//Test Variables
	int testType = 0;
	int typeToSet = 1;
	double testPercentage = .05;
	double percentageToSet = .10;
	
	//Test Array for Benefits Map
	Benefit[] benefitExampleMap = 
	{
			new Benefit(0,.05),
			new Benefit(1,.10),
			new Benefit(2,.15)
	};
	
	@Before
	public void setUp() throws Exception
	{
		testBenefit0 = new Benefit();	//Default Constructor
		testBenefit1 = new Benefit(1,.10);	//OverLoaded Constructor for rest of testBenefits
		testBenefit2 = new Benefit(2,.15);
		testBenefit3 = new Benefit(1,.20);	//Constructed incorrectly on purpose
		testBenefit4 = new Benefit(0,.25);	//Constructed incorrectly on purpose
	}
	
	@After
	public void tearDown() throws Exception
	{
		testBenefit0 = null;
		testBenefit1 = null;
		testBenefit2 = null;
		testBenefit3 = null;
		testBenefit4 = null;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public final void testDefaultBenefitsConstructor() throws Exception
	{
		assertEquals(testBenefit0.getBenefitType(), testBenefitType0);
		assertEquals(testBenefit0.getBenefitPercentage(), testBenefitPercentage0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public final void testOverloadedBenefitsConstructor() throws Exception
	{
		assertEquals(testBenefit1.getBenefitType(), testBenefitType1);
		assertEquals(testBenefit1.getBenefitPercentage(), testBenefitPercentage1);
		
		assertEquals(testBenefit2.getBenefitType(), testBenefitType2);
		assertEquals(testBenefit2.getBenefitPercentage(), testBenefitPercentage2);
		
		assertEquals(testBenefit3.getBenefitType(), testBenefitType2);
		assertEquals(testBenefit3.getBenefitPercentage(), testBenefitPercentage2);
		
		assertEquals(testBenefit4.getBenefitType(), testBenefitType1);
		assertEquals(testBenefit4.getBenefitPercentage(), testBenefitPercentage1);
	}
	
	@Test
	public final void testSetBenefitType() throws Exception
	{
		testBenefit0.setBenefitType(typeToSet);
		assertEquals(typeToSet, testBenefit0.getBenefitType());
		
		testBenefit1.setBenefitType(testType);
		assertEquals(testType, testBenefit1.getBenefitType());
	}
	
	@Test
	public final void testGetBenefitType() throws Exception
	{
		testBenefit0.setBenefitType(testType); //sets type to 0
		Benefit testBenefitType0 = testBenefit0;
		int benefitTypeTest0 = testBenefitType0.getBenefitType();
		assertEquals( benefitTypeTest0, testBenefit0.getBenefitType());
		
		testBenefit3.setBenefitType(typeToSet);
		Benefit testBenefitType3 = testBenefit3;
		int benefitTypeTest3 = testBenefitType3.getBenefitType();
		assertEquals( benefitTypeTest3, testBenefit3.getBenefitType());
		
		testBenefit4.setBenefitType(typeToSet);
		Benefit testBenefitType4 = testBenefit4;
		int benefitTypeTest4 = testBenefitType4.getBenefitType();
		assertEquals(benefitTypeTest4, testBenefit4.getBenefitType());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public final void testSetBenefitPercentage() throws Exception
	{
		testBenefit0.setBenefitPercentage(percentageToSet);
		assertEquals(percentageToSet, testBenefit0.getBenefitPercentage());
		
		testBenefit1.setBenefitPercentage(testPercentage);
		assertEquals(testPercentage, testBenefit1.getBenefitPercentage());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetBenefitPercentage() throws Exception
	{
		testBenefit0.setBenefitPercentage(testPercentage); //sets percentage to .05
		Benefit testBenefitPercentage0 = testBenefit0;
		double benefitPercentageTest0 = testBenefitPercentage0.getBenefitPercentage();
		assertEquals(benefitPercentageTest0, testBenefit0.getBenefitPercentage());
		
		testBenefit3.setBenefitPercentage(percentageToSet);	//Sets percentage to .10
		Benefit testBenefitPercentage3 = testBenefit3;
		double benefitPercentageTest3 = testBenefitPercentage3.getBenefitPercentage();
		assertEquals( benefitPercentageTest3, testBenefit3.getBenefitPercentage());
		
		testBenefit4.setBenefitPercentage(percentageToSet); //Sets percentage to .10
		Benefit testBenefitPercentage4 = testBenefit4;
		double benefitPercentageTest4 = testBenefitPercentage4.getBenefitPercentage();
		assertEquals(benefitPercentageTest4, testBenefit4.getBenefitPercentage());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetBenefitMap() throws Exception
	{
		Benefit[] exampleMap = testBenefit0.getBenefitsMap();
		assertEquals(exampleMap, benefitExampleMap);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetBenefit() throws Exception
	{
		double benefitTest0 = testBenefit0.getBenefit(testBenefit0.getBenefitType());
		assertEquals(benefitTest0, testBenefitPercentage0);
		
		double benefitTest1 = testBenefit1.getBenefit(testBenefit1.getBenefitType());
		assertEquals(benefitTest1, testBenefitPercentage1);
		
		double benefitTest2 = testBenefit2.getBenefit(testBenefit2.getBenefitType());
		assertEquals(benefitTest2, testBenefitPercentage2);
		
	}
}