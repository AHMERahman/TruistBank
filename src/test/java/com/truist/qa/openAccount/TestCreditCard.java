package com.truist.qa.openAccount;

import org.testng.annotations.Test;


import com.truist.qa.base.Base;

public class TestCreditCard extends Base{ 
	
	@Test
	
	public void openCreditCardAccount() {
	openAccountPage.OpenAccountSteps();
	
	}
	

}
