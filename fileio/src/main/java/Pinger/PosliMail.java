package Pinger;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PosliMail {

	public static void send()  {

		// nastavime vlastnosti pro odeslani, jedna se o vyuziti gmail uctu ktery je zdarma a spolehlivy, pripojime se tedy k nemu a z nej posleme email
		final Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		final Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// vyuzijeme prihlasovni pomoci jmena a hesla
						return new PasswordAuthentication("JavaSenderJT@gmail.com", "blablabla123");
					}
				});

		try {

			// vytvorime zpravu kterou budeme odesilat
			final Message message = new MimeMessage(session);
			
			// vyplnime adresu odesilatele, tedy stejny mail jako je prihlasovaci jmeno
			message.setFrom(new InternetAddress("JavaSenderJT@gmail.com"));
			
			// vyplnime komu budeme posilat email, tech muze byt vice
			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse("honzatt@seznam.cz"));
			
			// zadáme predmet emailu
			message.setSubject("Nedostupné IP adresy");
			
			// vyplnime telo emailu, to muze byt samozrejme slozeno z texu i hodnot (pri skladani doporucuji pouzit StringBuilder)
			message.setText(TestIP.nedostupne);

			// odesleme zpravu
			Transport.send(message);

		} catch (final MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
