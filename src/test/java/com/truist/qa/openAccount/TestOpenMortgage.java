package com.truist.qa.openAccount;

import org.testng.annotations.Test;
import com.truist.qa.base.Base;

public class TestOpenMortgage extends Base {
	
	@Test
	
	public void openMortgageAccount() {
		openMortgagePage.openMortgageSteps();
//		affordabilityCalculatorPage.affordabilityCalculatorSteps();
	}
	 
	
	

}
