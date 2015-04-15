package cz.bodyplan.be.spring.component;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import cz.bodyplan.web.interfaces.component.HTMLMail;

@Component
public class HTMLMailImpl implements HTMLMail {

	private static final Logger logger = Logger.getLogger(HTMLMailImpl.class);

	@Override
	public void sendMail(final String to, final String from, final String subject, final String messageText) throws Exception {
		logger.info("start email form " + from + " to " + to);
		final Properties props = new Properties();
		setProperties(props);

		final Session mailSession = Session.getDefaultInstance(props, null);
		final Transport transport = mailSession.getTransport();

		final MimeMessage message = new MimeMessage(mailSession);
		message.setSubject(subject, "UTF-8");

		message.setContent(messageText, "text/html; charset=UTF-8");
		message.addFrom(new InternetAddress[] { new InternetAddress(from) });
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		transport.connect();
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
		logger.info("end email form " + from + " to " + to);
	}

	private static void setProperties(final Properties props) {
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "localhost");
	}

}
