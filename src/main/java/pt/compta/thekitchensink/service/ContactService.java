package pt.compta.thekitchensink.service;

import pt.compta.thekitchensink.Contact;
import pt.compta.thekitchensink.repository.ContactRepository;

public class ContactService {
	private ContactRepository contactRepository = new ContactRepository();

	public Contact getContact(String name) {
		Contact contact = null;
		if ((contact = contactRepository.getByName(name)) != null)
			return contact;
		else
			throw new IllegalArgumentException();
	}

	public Contact createContact(Contact contact) {
		if ((contactRepository.getByName(contact.getFirstName()) != null)
				|| (contactRepository.getByName(contact.getLastName()) != null)) {
			throw new IllegalArgumentException();
		} else {
			contactRepository.insert(contact);
		}
		return contact;
	}
}
