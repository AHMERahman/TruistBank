package com.truist.qa.openAccount;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.truist.qa.base.Base;

import static utils.DataMap.*;
import utils.ExcelData;

public class TestOpenAccountDataMap extends Base {

	@DataProvider(name = "excelMap")
	public Object[][] mapData() {
		String pathString = configuration.getConfiguration("excelPath");
		String sheetNameString = configuration.getConfiguration("excelSheetMap");
		ExcelData excelData = new ExcelData(pathString, sheetNameString);
		int size = excelData.dataMap().size();
		Object[][] objects2d = new Object[size][1]; // need to understand more
		/*
		 * objects2d is an two-dimensional array Object[][] objects2d = new
		 * Object[size][1] define size = basically that many number of rows in dataMap 1
		 * = is basically each dataMap index has one map
		 */
		for (int i = 0; i < size; i++) {
			objects2d[i][0] = excelData.dataMap().get(i);
		}
		return objects2d;
	}

	@Test(enabled = false, dataProvider = "excelMap")

	public void openCreditCardAccountMapDataProvider(Map<String, String> map) {
		openAccountPage.openAccountSteps(map.get("SubHeading"), map.get("url"));

		goToPersonalInfoFormPage.goToPersonalInfoFormPageSteps(map.get("Sub-title"), map.get("Zipcode"),
				map.get("Sub-title2"));

		personalInfoPage.personalInfoPageSteps(map.get("FirstName"), map.get("LastName"), map.get("DOB"),
				map.get("SSN"), map.get("Mobile"));
	}

	@Test(enabled = true, dataProvider = "excelMap")

	public void openCreditCardAccountMapDataProviderWithEnam(Map<String, String> map) {
		openAccountPage.openAccountSteps(map.get(SubHeading.getValue()), map.get(url.name()));

		goToPersonalInfoFormPage.goToPersonalInfoFormPageSteps(map.get(SubTitle.getValue()), map.get(ZipCode.getValue()),
				map.get(SubTitle2.getValue()));

		personalInfoPage.personalInfoPageSteps(map.get(FirstName.getValue()), map.get(LastName.getValue()),
				map.get(DOB.getValue()), map.get(SSN.getValue()), map.get(Mobile.getValue()));
	}
}
