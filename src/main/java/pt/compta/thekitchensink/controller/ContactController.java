package pt.compta.thekitchensink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.compta.thekitchensink.controller.converter.ContactModelConverter;
import pt.compta.thekitchensink.controller.model.ContactModel;
import pt.compta.thekitchensink.service.ContactService;
import pt.compta.thekitchensink.service.domain.Contact;

@RestController
public class ContactController {
	@Autowired
	private ContactService contactService;

	@Autowired
	private ContactModelConverter contactModelConverter;

	@GetMapping("/contacts")
	public ContactModel contact(@RequestParam("name") String nameParamValue) {
		return contactModelConverter.convertFromContactToContactModel(contactService.getContact(nameParamValue));
	}

	@PostMapping("/contacts")
	public ContactModel createContact(@RequestBody ContactModel contactModel) {
		Contact contact = contactModelConverter.convert(contactModel);
		contactService.createContact(contact);
		return contactModel;
	}
}