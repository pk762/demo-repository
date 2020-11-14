package whz.pti.eva.pizzaService.customer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Customer {
	
	@Id
	private String userId;
	
	private String firstName;
	private String lastName;
	private String loginName;
	private String passwordHash;
	
	@ManyToMany
	private List<DeliveryAddress> address;
	
	public Customer () {}
	

	public Customer (String firstName, String lastName, String login, String password, List<DeliveryAddress> address) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setLoginName(login);
		this.setPasswordHash(password);
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
}
