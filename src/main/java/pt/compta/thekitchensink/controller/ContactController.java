package pt.compta.thekitchensink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.compta.thekitchensink.Contact;
import pt.compta.thekitchensink.service.ContactService;

@RestController
public class ContactController {
	@Autowired
	private ContactService contactService;

	@GetMapping("/contacts")
	public Contact contact(@RequestParam("name") String nameParamValue) {
		return contactService.getContact(nameParamValue);
	}

	@PostMapping("/contacts")
	public Contact createContact(@RequestBody Contact contact) {
		contactService.createContact(contact);
		return contact;
	}
}
