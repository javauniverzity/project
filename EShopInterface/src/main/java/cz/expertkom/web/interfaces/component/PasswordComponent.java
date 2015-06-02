package cz.expertkom.web.interfaces.component;

import cz.expertkom.web.vo.dto.User;

/**
 * Komponenta k práci s hesly
 */

public interface PasswordComponent {

	/**
	 * Náhodné heslo
	 */
	String getRandomPassword();

	/**
	 * Heslo na základì uživatelského jména 
	 */
	String getMd5Password(User user, String password);

}
