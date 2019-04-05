package pt.compta.thekitchensink.service.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.repository.entity.ContactEntity;
import pt.compta.thekitchensink.service.domain.Contact;

@Component
public class ContactConverter {
	public Contact convert(ContactEntity source) {
		String contactFirstName = source.getFirstName();
		String contactLastName = source.getLastName();
		int contactPhoneNumber = source.getPhoneNumber();
		String contactEmailAddress = source.getEmailAddress();
		return new Contact(contactFirstName, contactLastName, contactPhoneNumber, contactEmailAddress);
	}

	public ContactEntity convertFromContactToContactEntity(Contact source) {
		String contactFirstName = source.getFirstName();
		String contactLastName = source.getLastName();
		int contactPhoneNumber = source.getPhoneNumber();
		String contactEmailAddress = source.getEmailAddress();
		return new ContactEntity(contactFirstName, contactLastName, contactPhoneNumber, contactEmailAddress);
	}
}
