package cz.expertkom.be.spring.component;

import java.security.SecureRandom;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;

import cz.expertkom.web.interfaces.component.PasswordComponent;
import cz.expertkom.web.vo.dto.User;

/**
 * Implementace komponenty na spravu hesla
 * @author David
 *
 */
@Component
public class PasswordComponentImpl implements PasswordComponent {

	private final Logger logger = Logger.getLogger(PasswordComponentImpl.class);
	

	/**
	 * Implementace hesla na zaklade uzivatelskeho jmena 
	 */
	@Override
	public String getMd5Password(final User user, final String password) {
		final Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		final ReflectionSaltSource salt = new ReflectionSaltSource();
		salt.setUserPropertyToUse("getUsername");

		final String result = encoder.encodePassword(password, salt.getSalt(user));
		return result;
	}

	/**
	 * Implementace nahodneho hesla
	 */
	@Override
	public String getRandomPassword() {
		final String str = new String("QAabcdUK2eHfJgTP8XhFj6DkNm9nB5pGqYVrs3CtSuMZvwWx4yE7zR");
		final StringBuffer sb = new StringBuffer();
		final SecureRandom r = new SecureRandom();
		int te = 0;
		for (int i = 0; i < 6; i++) {
			te = r.nextInt(str.length());
			sb.append(str.charAt(te));
		}
		final String password = sb.toString();
		logger.debug("PasswordComponent: Random Password is \"" + password + "\"");
		return password;
	}

}
