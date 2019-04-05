package pt.compta.thekitchensink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.compta.thekitchensink.Contact;
import pt.compta.thekitchensink.repository.ContactEntity;
import pt.compta.thekitchensink.repository.ContactRepository;
import pt.compta.thekitchensink.service.converter.ContactConverter;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactConverter contactConverter;

	public Contact getContact(String name) {
		ContactEntity contact = null;
		if ((contact = contactRepository.getByName(name)) != null)
			return contactConverter.convert(contact);
		else
			throw new IllegalArgumentException();
	}

	public Contact createContact(Contact contact) {
		ContactEntity entity = contactConverter.convertFromContactToContactEntity(contact);
		if (doesContactExist(contact)) {
			throw new IllegalArgumentException();
		} else {
			contactRepository.insert(entity);
		}
		return contact;
	}

	public boolean doesContactExist(Contact contact) {
		return contactRepository.getByName(contact.getFirstName()) != null
				|| contactRepository.getByName(contact.getLastName()) != null;
	}
}
