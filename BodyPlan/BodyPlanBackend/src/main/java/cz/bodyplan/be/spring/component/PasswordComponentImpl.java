package cz.bodyplan.be.spring.component;

import java.security.SecureRandom;

import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;

import cz.bodyplan.web.interfaces.component.PasswordComponent;
import cz.bodyplan.web.vo.dto.User;

@Component
public class PasswordComponentImpl implements PasswordComponent {

	@Override
	public String getMd5Password(final User user, final String password) {
		final Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		final ReflectionSaltSource salt = new ReflectionSaltSource();
		salt.setUserPropertyToUse("getUsername");

		final String result = encoder.encodePassword(password, salt.getSalt(user));
		return result;
	}

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
		return password;
	}

}
