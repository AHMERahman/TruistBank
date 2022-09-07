package utils;

public enum DataMap {

	SubHeading("SubHeading"), url("url"), SubTitle("Sub-title"), ZipCode("Zipcode"), SubTitle2("Sub-title2"),
	FirstName("FirstName"), LastName("LastName"), DOB("DOB"), SSN("SSN"), Mobile("Mobile");

	private String value;

	private DataMap(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
