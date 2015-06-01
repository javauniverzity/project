package cz.expertkom.web.interfaces.component;

import cz.expertkom.web.vo.dto.User;

/**
 * Komponenta k pr�ci s hesly
 */

public interface PasswordComponent {

	/**
	 * N�hodn� heslo
	 */
	String getRandomPassword();

	/**
	 * Heslo na z�klad� u�ivatelsk�i jm�na 
	 */
	String getMd5Password(User user, String password);

}
