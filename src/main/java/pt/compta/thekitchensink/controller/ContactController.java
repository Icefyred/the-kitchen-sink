package pt.compta.thekitchensink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.compta.thekitchensink.controller.converter.ContactModelToContactConverter;
import pt.compta.thekitchensink.controller.converter.ContactToContactModelConverter;
import pt.compta.thekitchensink.controller.model.ContactModel;
import pt.compta.thekitchensink.service.ContactService;
import pt.compta.thekitchensink.service.domain.Contact;

@RestController
public class ContactController {
	@Autowired
	private ContactService contactService;

	@Autowired
	private ContactModelToContactConverter contactModelToContactConverter;

	@Autowired
	private ContactToContactModelConverter contactToContactModelConverter;

	@GetMapping("/contacts")
	public ContactModel contact(@RequestParam("name") String nameParamValue) {
		return contactModelToContactConverter.convert(contactService.getContact(nameParamValue));
	}

	@PostMapping("/contacts")
	public ContactModel createContact(@RequestBody ContactModel contactModel) {
		Contact contact = contactToContactModelConverter.convert(contactModel);
		contactService.createContact(contact);
		return contactModel;
	}
}