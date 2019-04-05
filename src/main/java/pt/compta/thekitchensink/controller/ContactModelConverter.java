package pt.compta.thekitchensink.controller;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Contact;

@Component
public class ContactModelConverter {
	public Contact convert(ContactModel source) {
		String contactFirstName = source.getFirstName();
		String contactLastName = source.getLastName();
		int contactPhoneNumber = source.getPhoneNumber();
		String contactEmailAddress = source.getEmailAddress();
		return new Contact(contactFirstName, contactLastName, contactPhoneNumber, contactEmailAddress);
	}

	public ContactModel convertFromContactToContactModel(Contact source) {
		String contactFirstName = source.getFirstName();
		String contactLastName = source.getLastName();
		int contactPhoneNumber = source.getPhoneNumber();
		String contactEmailAddress = source.getEmailAddress();
		return new ContactModel(contactFirstName, contactLastName, contactPhoneNumber, contactEmailAddress);
	}
}
