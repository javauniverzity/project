package cz.expertkom.web.vo.dto;

import java.util.Date;

/**
 * Data pro zapamatovane prihlaseni
 * 
 * @author Pavel Lukes
 * 
 */

public class PersistentLogins {

	private String username;

	private String series;

	private String token;

	private Date last_used;

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(final String series) {
		this.series = series;
	}

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public Date getLast_used() {
		return last_used;
	}

	public void setLast_used(final Date last_used) {
		this.last_used = last_used;
	}

}
