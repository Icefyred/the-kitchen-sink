package pt.compta.thekitchensink;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
	private List<Contact> contactsInMemory = new ArrayList<>();

	public void insert(Contact contact) {
		contactsInMemory.add(contact);
		System.out.println("Inserted object: " + contact);
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
