package cz.bodyplan.web.vo.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import cz.bodyplan.web.vo.constants.Enums.ExcerciseLevel;
import cz.bodyplan.web.vo.constants.Enums.Formula;
import cz.bodyplan.web.vo.constants.Enums.Goal;
import cz.bodyplan.web.vo.constants.Enums.Plan;
import cz.bodyplan.web.vo.constants.Enums.Sex;

/**
 * Data pro prihlasovani a overovani uzivatele. Jedna se o systemoveho
 * uzivatele, operatora i klienta
 * 
 * @author Pavel Lukes
 * 
 */

public class User implements UserDetails, Serializable {

	private String firstName;
	private String lastName;
	private Date createDate;
	private Float bmr;
	private Float tdee;

	private Float weight;
	private Float height;
	private Float age;

	private String email;

	private String excerciseLevel;
	private String plan;
	private String formula;

	private String goal;
	private String sex;

	private static final long serialVersionUID = 1807419766045433889L;

	public User() {
		super();
	}

	private Long id;

	/**
	 * heslo uzivatele
	 */
	private String password;

	/**
	 * uzivatelske jmeno, muze byt facebook id nebo emailova adresa
	 */
	private String username;

	private boolean enabled = true;

	private Set<Authority> authorities;

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public Collection<Authority> getAuthorities() {
		if (authorities == null) {
			return new HashSet<Authority>();
		}
		return authorities;
	}

	public void setAuthorities(final Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(final Date createDate) {
		this.createDate = createDate;
	}

	public Float getBmr() {
		return bmr;
	}

	public void setBmr(final Float bmr) {
		this.bmr = bmr;
	}

	public Float getTdee() {
		return tdee;
	}

	public void setTdee(final Float tdee) {
		this.tdee = tdee;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(final Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(final Float height) {
		this.height = height;
	}

	public Float getAge() {
		return age;
	}

	public void setAge(final Float age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public ExcerciseLevel getExcerciseLevel() {
		if (excerciseLevel == null) {
			return null;
		}
		return ExcerciseLevel.valueOf(excerciseLevel);
	}

	public void setExcerciseLevel(final ExcerciseLevel excerciseLevel) {
		if (excerciseLevel == null) {
			return;
		}
		this.excerciseLevel = excerciseLevel.name();
	}

	public Plan getPlan() {
		if (plan == null) {
			return null;
		}
		return Plan.valueOf(plan);
	}

	public void setPlan(final Plan plan) {
		if (plan == null) {
			return;
		}
		this.plan = plan.name();
	}

	public Formula getFormula() {
		if (formula == null) {
			return null;
		}
		return Formula.valueOf(formula);
	}

	public void setFormula(final Formula formula) {
		if (formula == null) {
			return;
		}
		this.formula = formula.name();
	}

	public Goal getGoal() {
		if (goal == null) {
			return null;
		}
		return Goal.valueOf(goal);
	}

	public void setGoal(final Goal goal) {
		if (goal == null) {
			return;
		}
		this.goal = goal.name();
	}

	public Sex getSex() {
		if (sex == null) {
			return null;
		}
		return Sex.valueOf(sex);
	}

	public void setSex(final Sex sex) {
		if (sex == null) {
			return;
		}
		this.sex = sex.name();
	}

	public String getExcerciseLevelValue() {
		return excerciseLevel;
	}

	public void setExcerciseLevelValue(final String excerciseLevelValue) {
		this.excerciseLevel = excerciseLevelValue;
	}

	public String getPlanValue() {
		return plan;
	}

	public void setPlanValue(final String planValue) {
		this.plan = planValue;
	}

	public String getFormulaValue() {
		return formula;
	}

	public void setFormulaValue(final String formulaValue) {
		this.formula = formulaValue;
	}

	public String getGoalValue() {
		return goal;
	}

	public void setGoalValue(final String goalValue) {
		this.goal = goalValue;
	}

	public String getSexValue() {
		return sex;
	}

	public void setSexValue(final String sexValue) {
		this.sex = sexValue;
	}

}
