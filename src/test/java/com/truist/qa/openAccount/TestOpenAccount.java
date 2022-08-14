package com.truist.qa.openAccount;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.truist.qa.base.Base;

public class TestOpenAccount extends Base {

	@Test

	public void openCreditCardAccount() {
		openAccountPage.openAccountSteps("Compare Truist Visa® credit cards",
				"https://www.truist.com/credit-cards/enjoy-cash", "OPTION 1",
				"https://creditcard.digitalcommerce.truist.com/product/welcome",
				"You're applying for the Truist Enjoy Cash Credit Card.", "Let's get started.", "17057");
	}

}
