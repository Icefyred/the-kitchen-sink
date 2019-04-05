package pt.compta.thekitchensink.service.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Converter;
import pt.compta.thekitchensink.repository.entity.ContactEntity;
import pt.compta.thekitchensink.service.domain.Contact;

@Component
public class ContactConverter implements Converter<ContactEntity, Contact> {
	public Contact convertFrom(ContactEntity source) {
		String contactFirstName = source.getFirstName();
		String contactLastName = source.getLastName();
		int contactPhoneNumber = source.getPhoneNumber();
		String contactEmailAddress = source.getEmailAddress();
		return new Contact(contactFirstName, contactLastName, contactPhoneNumber, contactEmailAddress);
	}

	public ContactEntity convertTo(Contact source) {
		String contactFirstName = source.getFirstName();
		String contactLastName = source.getLastName();
		int contactPhoneNumber = source.getPhoneNumber();
		String contactEmailAddress = source.getEmailAddress();
		return new ContactEntity(contactFirstName, contactLastName, contactPhoneNumber, contactEmailAddress);
	}
}
