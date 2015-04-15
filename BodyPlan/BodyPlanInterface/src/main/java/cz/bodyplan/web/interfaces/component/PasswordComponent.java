package cz.bodyplan.web.interfaces.component;

import cz.bodyplan.web.vo.dto.User;

public interface PasswordComponent {

	String getMd5Password(User user, String password);

	String getRandomPassword();

}
