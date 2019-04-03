package pt.compta.thekitchensink.service;

import pt.compta.thekitchensink.Contact;
import pt.compta.thekitchensink.repository.ContactRepository;

public class ContactService {
	private ContactRepository contactRepository = new ContactRepository();

	public Contact getContact(String name) {
		return contactRepository.getByName(name);
	}

	public Contact createContact(Contact contact) {
		contactRepository.insert(contact);
		return contact;
	}
}
