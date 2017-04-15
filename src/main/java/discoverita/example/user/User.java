package discoverita.example.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class User {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	public User () {};

	public User (String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	@NotNull
	@Size(min=5, max=16, message="{firstName.size}")
	public String getFirstName() {
		return firstName;
	}

	@NotNull
	@Size(min=5, max=16)
	public String getLastName() {
		return lastName;
	}

	@NotNull
	@Size(min=5, max=16)
	public String getUserName() {
		return userName;
	}

	
	@NotNull
	@Size(min=5, max=25)
	public String getPassword() {
		return password;
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "firstName", "lastName", "password");
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "password");
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
