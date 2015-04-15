package cz.bodyplan.be.spring.exception;

import cz.bodyplan.web.interfaces.exception.BusinessException;

public class WrongUserException extends BusinessException {

	private static final long serialVersionUID = -6370389368662066131L;

	@Override
	public Exception getException() {
		return Exception.WRONG_USER;
	}
}
