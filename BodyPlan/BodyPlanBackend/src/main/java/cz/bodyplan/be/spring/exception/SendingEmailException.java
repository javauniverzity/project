package cz.bodyplan.be.spring.exception;

import cz.bodyplan.web.interfaces.exception.BusinessException;

public class SendingEmailException extends BusinessException {

	private static final long serialVersionUID = -8240738343549455551L;

	@Override
	public Exception getException() {
		return Exception.SENDING_EMAIL;
	}
}
