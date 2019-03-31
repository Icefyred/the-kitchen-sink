package pt.compta.thekitchensink;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public Contact contact(@RequestParam("id") String stringValue) {
		return new Contact("Diogo", "Castilho", 969168884, "dcastilho001@hotmail.com");
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public Contact createContact(@RequestBody Contact contact) {
		System.out.println("First Name: " + contact.getFirstName());
		System.out.println("Last Name: " + contact.getLastName());
		System.out.println("Phone Number: " + contact.getPhoneNumber());
		System.out.println("Email Address: " + contact.getEmailAddress());
		return contact;
	}
}
