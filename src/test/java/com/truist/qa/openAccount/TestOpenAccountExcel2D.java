package com.truist.qa.openAccount;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.truist.qa.base.Base;

import utils.ExcelData;
import utils.PersonalInfoData;

public class TestOpenAccountExcel2D extends Base{

	@DataProvider(name = "personalInfoData2DExcel")
	public Object[][] autoData(){
		String pathString = configuration.getConfiguration("excelPath");
		String sheetNameString = configuration.getConfiguration("excelSheet");
		ExcelData excelData = new ExcelData(pathString, sheetNameString);
		return excelData.dataObjects();
	}
	
	@Test(enabled = true, dataProvider = "personalInfoData2DExcel")

	public void openCreditCardAccount(String expected, String expectedUrl, String expectedSubheading, String value, String expected2, String firstName, String lastName, String dob, String ssn, String mobileNum) {
		openAccountPage.openAccountSteps(expected, expectedUrl);

		goToPersonalInfoFormPage.goToPersonalInfoFormPageSteps(expectedSubheading, value, expected2);

		personalInfoPage.personalInfoPageSteps(firstName, lastName, dob, ssn, mobileNum);

	}
	
	
	
}
