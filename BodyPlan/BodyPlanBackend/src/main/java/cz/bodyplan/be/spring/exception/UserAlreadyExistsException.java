package cz.bodyplan.be.spring.exception;

import cz.bodyplan.web.interfaces.exception.BusinessException;

public class UserAlreadyExistsException extends BusinessException {

	private static final long serialVersionUID = -8980195257458412863L;

	@Override
	public Exception getException() {
		return Exception.USER_ALREADY_EXISTS;
	}
}
