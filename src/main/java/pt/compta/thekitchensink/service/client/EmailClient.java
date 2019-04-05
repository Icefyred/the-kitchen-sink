package pt.compta.thekitchensink.service.client;

import org.springframework.stereotype.Component;

@Component
public class EmailClient {
	public void sendEmail(String emailAddressDestiny) {
		System.out.println("Sending email...");
	}
}
