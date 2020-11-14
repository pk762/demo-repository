package whz.pti.eva.pizzaService.customer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class DeliveryAddress {

	@Id @GeneratedValue
	private Long id; 
	private String street;
	private String houseNumber;
	private String town;
	private String postalCode;
	
	@ManyToMany
	private List<Customer> customer;

	public DeliveryAddress(Long id, String street, String houseNumber, String town, String postalCode,
			List<Customer> customer) {
		super();
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
		this.town = town;
		this.postalCode = postalCode;
		this.customer = customer;
	} 
	
	
}
