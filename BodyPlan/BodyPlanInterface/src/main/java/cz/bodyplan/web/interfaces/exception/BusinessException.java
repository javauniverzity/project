package cz.bodyplan.web.interfaces.exception;

public abstract class BusinessException extends Exception {

	public enum Exception {
		WRONG_TASK_STATUS(5), WRONG_USER(6), USER_ALREADY_EXISTS(7), WRONG_PARAMETERS(8), SENDING_EMAIL(9), USER_NOT_FOUND(10), BAD_USERNAME_OR_PASSWORD(11), SENDING_GCM(12), COMPONENT_ALREADY_EXISTS(
				13), SECURITY(14);

		private final Integer code;

		private Exception(final Integer code) {
			this.code = code;
		}

		public Integer getCode() {
			return code;
		}
	}

	private static final long serialVersionUID = 8912179558625075505L;

	public abstract Exception getException();

}
