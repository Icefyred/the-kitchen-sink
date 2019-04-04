package pt.compta.thekitchensink.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pt.compta.thekitchensink.Contact;

@Repository
public class ContactRepository {
	private List<Contact> contactsInMemory = new ArrayList<>();

	public void insert(Contact contact) {
		contactsInMemory.add(contact);
	}

	public Contact getByName(String stringValue) {

		for (Contact contact : contactsInMemory) {
			if (stringValue.equals(contact.getFirstName()) || stringValue.equals(contact.getLastName())) {
				return contact;
			}
		}
		return null;
	}
}
