package pt.compta.thekitchensink.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pt.compta.thekitchensink.repository.entity.ContactEntity;

@Repository
public class ContactRepository {
	private List<ContactEntity> contactsInMemory = new ArrayList<>();

	public void insert(ContactEntity contact) {
		contactsInMemory.add(contact);
	}

	public ContactEntity getByName(String stringValue) {

		for (ContactEntity contact : contactsInMemory) {
			if (stringValue.equals(contact.getFirstName()) || stringValue.equals(contact.getLastName())) {
				return contact;
			}
		}
		return null;
	}
}
