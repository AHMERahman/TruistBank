package com.truist.qa.openAccount;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.truist.qa.base.Base;
import utils.PersonalInfoData;

public class TestDataOpenAccount extends Base {

	@DataProvider(name = "personalInfoDataIterator")
	public Iterator<PersonalInfoData> personalInfoDataIterator() {

		List<PersonalInfoData> list = new ArrayList<PersonalInfoData>();
		PersonalInfoData personalInfoData1 = new PersonalInfoData("I'm not a client", "17057", "Let's get started.",
				"Brian", "Mondol", "10/10/1990", "212121212", "717-000-0000");
		PersonalInfoData personalInfoData2 = new PersonalInfoData("I'm not a client", "17036", "Let's get started.",
				"Brad", "Pitt", "10/12/1992", "232323232", "777-000-0000");
		list.add(personalInfoData1);
		list.add(personalInfoData2);

		return list.iterator();
	}
	
	@DataProvider(name = "personalInfoDataObject")
	public Object[][] autoDataObject() {
		PersonalInfoData personalInfoData1 = new PersonalInfoData("I'm not a client", "17057", "Let's get started.",
				"Brian", "Mondol", "10/10/1990", "212121212", "717-000-0000");
		PersonalInfoData personalInfoData2 = new PersonalInfoData("I'm not a client", "17036", "Let's get started.",
				"Brad", "Pitt", "10/12/1992", "232323232", "777-000-0000");
		return new Object[][] {{personalInfoData1}, {personalInfoData2}};
	}

	
	@Test(enabled = true, dataProvider = "personalInfoDataObject")

	public void openCreditCardAccount(PersonalInfoData personalInfoData) {
		openAccountPage.openAccountSteps("Compare Truist Visa® credit cards",
				"https://creditcard.digitalcommerce.truist.com/product/welcome");

		goToPersonalInfoFormPage.goToPersonalInfoFormPageSteps(personalInfoData);

		personalInfoPage.personalInfoPageSteps(personalInfoData);

	}

}
