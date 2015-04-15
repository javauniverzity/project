package cz.bodyplan.web.interfaces.component;

import cz.bodyplan.web.vo.dto.User;

public interface CurrentUserComponent {

	public User getCurrentUser();

	public String getCurrentUsername();
}
