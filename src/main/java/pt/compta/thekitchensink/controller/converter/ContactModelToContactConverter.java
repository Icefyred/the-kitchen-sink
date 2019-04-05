package pt.compta.thekitchensink.controller.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Converter;
import pt.compta.thekitchensink.controller.model.ContactModel;
import pt.compta.thekitchensink.service.domain.Contact;

@Component
public class ContactModelToContactConverter implements Converter<ContactModel, Contact> {

	public ContactModel convert(Contact source) {
		String contactFirstName = source.getFirstName();
		String contactLastName = source.getLastName();
		int contactPhoneNumber = source.getPhoneNumber();
		String contactEmailAddress = source.getEmailAddress();
		return new ContactModel(contactFirstName, contactLastName, contactPhoneNumber, contactEmailAddress);
	}
}
