package cz.bodyplan.be.spring.exception;

import cz.bodyplan.web.interfaces.exception.BusinessException;

public class WrongParamtersException extends BusinessException {

	private static final long serialVersionUID = -3177562265063598130L;

	@Override
	public Exception getException() {
		return Exception.WRONG_PARAMETERS;
	}
}
