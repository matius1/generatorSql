import java.sql.Date;

public class Customer {

	private String name;
	private String surname;
	private String sex;
	private java.sql.Date createDate;
	private java.sql.Date birthDate;

	public Customer() {

	}

	public Customer(String name, String surname, String sex, Date createDate, Date birthDate) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.createDate = createDate;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex() {
		if (name.endsWith("A")) {
			this.sex = "F";
		} else
			this.sex = "M";

	}

	public java.sql.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}

	public java.sql.Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", sex=" + sex + ", createDate=" + createDate
				+ ", birthDate=" + birthDate + "]";
	}

	public String sqlQeury() {
		return "NULL, \"" + name + "\", \"" + surname + "\", '" + birthDate + "', '" + createDate + "', \"" + sex + "\"";

	}

}
