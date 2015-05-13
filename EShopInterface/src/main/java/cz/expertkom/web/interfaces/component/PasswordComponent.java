package cz.expertkom.web.interfaces.component;

import cz.expertkom.web.vo.dto.User;

public interface PasswordComponent {

	String getRandomPassword();

	String getMd5Password(User user, String password);

}
