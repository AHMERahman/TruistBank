package com.truist.qa.openAccount;

import org.testng.annotations.Test;

import com.truist.qa.base.Base;

public class TestOpenAccount extends Base {

	@Test

	public void openCreditCardAccount() {
		openAccountPage.openAccountSteps("Compare Truist Visa? credit cards",
				"https://creditcard.digitalcommerce.truist.com/product/welcome");

		goToPersonalInfoFormPage.goToPersonalInfoFormPageSteps("I'm not a client", "17057", "Let's get started.");

		personalInfoPage.personalInfoPageSteps("Brian", "Mondol", "10/10/1990", "212121212", "717-000-0000");

	}

}
