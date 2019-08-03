package model;

public class Benefit
{
	private int benefitType;
	private double benefitPercentage;
	
	//default constructor
	public Benefit()
	{
		benefitType = 0;
		benefitPercentage = .05;
	}
	
	//Constructor with arguments
	public Benefit(int typeOfBenefit,double percentageOfBenefit)
	{
		benefitType = typeOfBenefit;
		benefitPercentage = percentageOfBenefit;
	}
	
	//Mutator Method for Benefit Type
	public int getBenefitType()
	{
		return benefitType;
	}
	
	//Accessor Method for Benefit Type
	public void setBenefitType(int benefitTypeToSet)
	{
		benefitType = benefitTypeToSet;
	}
	
	//Mutator Method for Benefit Percentage
	public double getBenefitPercentage()
	{
		return benefitPercentage;
	}
	
	//Accessor Method for Benefit Percentage
	public void setBenefitPercentage(double benefitPercentageToSet)
	{
		System.out.println("Setting the member discount percentage too: " + benefitPercentageToSet);
		benefitPercentage = benefitPercentageToSet;
		System.out.println("Confirming that the member discount percentage has been set too: " + benefitPercentageToSet);
	}
	
	//Standard Benefit's Array
	Benefit mapOfBenefits[] = 
	{
			new Benefit(0,.05),
			new Benefit(1,.10),
			new Benefit(2,.15)
	};
	
	//Accessor method for getting the standard Benefit's Array.
	public Benefit[] getBenefitsMap()
	{
		System.out.println("Retrieving standard Benefit's Array");
		return mapOfBenefits;
	}
	
	//Accessor method for getting the benefit percentage from a provided Benefit Type variable.
	@SuppressWarnings("unused")
	public double getBenefit(int userBenefitType)
	{
		for(int i = 0; i < mapOfBenefits.length; i++)
		{
			if(userBenefitType == mapOfBenefits[i].getBenefitType())
				System.out.println("Discount Rate is: " + (mapOfBenefits[i].getBenefitPercentage()*100) + " %");
				return mapOfBenefits[i].getBenefitPercentage();
		}
		System.out.println("Benefits not found for user type!");
		return 0;
	}
}