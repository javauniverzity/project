package cz.bodyplan.web.interfaces.component;

public interface HTMLMail {

	void sendMail(String to, String from, String subject, String messageText) throws Exception;

}
