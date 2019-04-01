package pt.compta.thekitchensink;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	private ContactRepository contactRepository = new ContactRepository();

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public Contact contact(@RequestParam("name") String nameParamValue) {
		return contactRepository.getByName(nameParamValue);
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public Contact createContact(@RequestBody Contact contact) {
		System.out.println("First Name: " + contact.getFirstName());
		System.out.println("Last Name: " + contact.getLastName());
		System.out.println("Phone Number: " + contact.getPhoneNumber());
		System.out.println("Email Address: " + contact.getEmailAddress());
		contactRepository.insert(contact);
		return contact;
	}
}
