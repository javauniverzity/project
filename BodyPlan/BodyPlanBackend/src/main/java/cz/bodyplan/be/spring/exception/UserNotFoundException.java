package cz.bodyplan.be.spring.exception;

import cz.bodyplan.web.interfaces.exception.BusinessException;

public class UserNotFoundException extends BusinessException {

	private static final long serialVersionUID = -2181591589432301556L;

	@Override
	public Exception getException() {
		return Exception.USER_NOT_FOUND;
	}
}
