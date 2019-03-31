package pt.compta.thekitchensink;

public class Contact {
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String emailAddress;

	public Contact(String firstName, String lastName, int phoneNumber, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}
}