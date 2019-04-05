package pt.compta.thekitchensink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.compta.thekitchensink.repository.ContactRepository;
import pt.compta.thekitchensink.repository.entity.ContactEntity;
import pt.compta.thekitchensink.service.client.EmailClient;
import pt.compta.thekitchensink.service.converter.ContactConverter;
import pt.compta.thekitchensink.service.domain.Contact;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactConverter contactConverter;

	@Autowired
	private EmailClient emailClient;

	public Contact getContact(String name) {
		ContactEntity contact = null;
		if ((contact = contactRepository.getByName(name)) != null)
			return contactConverter.convertFrom(contact);
		else
			throw new IllegalArgumentException();
	}

	public Contact createContact(Contact contact) {
		ContactEntity entity = contactConverter.convertTo(contact);
		if (doesContactExist(contact)) {
			throw new IllegalArgumentException();
		} else {
			contactRepository.insert(entity);
			emailClient.sendEmail(entity.getEmailAddress());
		}
		return contact;
	}

	public boolean doesContactExist(Contact contact) {
		return contactRepository.getByName(contact.getFirstName()) != null
				|| contactRepository.getByName(contact.getLastName()) != null;
	}
}
