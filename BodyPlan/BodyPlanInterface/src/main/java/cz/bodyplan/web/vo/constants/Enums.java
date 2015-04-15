package cz.bodyplan.web.vo.constants;

public class Enums {

	public enum Goal {
		LOOSE_RECOMMENDED, LOOSE_AGGRESSIVE, LOOSE_RUTHLESS, KEEP, GAIN_RECOMMEND, GAIN_BOOK, GAIN_AGGRESSIVE;
	}

	public enum ExcerciseLevel {
		NONE, WEEK1, WEEK2, WEEK3, WEEK4, WEEK5, WEEK6, WEEK5INTENSE, DAILY, TWICEADAY, DAILYLABOR, PROFI;

	}

	public enum Plan {
		FREE, SILVER, GOLD, ASTAT;
	}

	public static enum Formula {
		MIFFLIN_ST_JEOR, HARRIS_BENEDICT, KATCH_MCCARDLE;
	}

	public static enum Sex {
		MALE, FEMALE;
	}

	public static enum Role {
		// u prava dodrzovat ROLE_CEHO_VIEW|CHANGE|REMOVE
		WAITING("ROLE_WAITING"), // nepotvrzeny uzivatel
		USER("ROLE_USER"), // bezny uzivatel
		ADMIN("ROLE_ADMIN"), // administrator
		ANONYMOUS("ROLE_ANONYMOUS"); // zaregistrovany, ale bez emailu a dalsiho infa

		private final String name;

		private Role(final String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

}
