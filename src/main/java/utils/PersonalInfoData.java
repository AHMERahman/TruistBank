package utils;

public class PersonalInfoData {

	private String expectedSubHeading;
	private String zipCode;
	private String expectedSubheading2;
	private String firstName;
	private String lastName;
	private String dob;
	private String ssn;
	private String mobileNum;
	
	
		public PersonalInfoData(String expectedSubHeading, String zipCode, String expectedSubheading2, String firstName, String lastName, String dob, String ssn, String mobileNum) {
		this.expectedSubHeading = expectedSubHeading;
		this.zipCode = zipCode;
		this.expectedSubheading2 = expectedSubheading2;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.ssn = ssn;
		this.mobileNum = mobileNum;
	}


		public String getFirstName() {
			return firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public String getDob() {
			return dob;
		}


		public String getSsn() {
			return ssn;
		}
		
		public String getMobileNum() {
			return mobileNum;
		}


		public String getExpectedSubHeading() {
			return expectedSubHeading;
		}


		public String getZipCode() {
			return zipCode;
		}


		public String getExpectedSubheading2() {
			return expectedSubheading2;
		}


		
	
	
	
	
	
	
	
}
