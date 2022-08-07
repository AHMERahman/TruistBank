package com.truist.qa.openAccount;

import org.testng.annotations.Test;

import com.truist.qa.base.Base;

public class TestCreditCard extends Base {

	@Test

	public void openCreditCardAccount() {
		openAccountPage.OpenAccountSteps("Compare Truist Visa® credit cards",
				"https://www.truist.com/credit-cards/enjoy-cash", "OPTION 1",
				"https://creditcard.digitalcommerce.truist.com/product/welcome", "You're applying for the Truist Enjoy Cash Credit Card.");

	}

}
