package whz.pti.eva.pizzaService.security.service.customer;

import whz.pti.eva.pizzaService.security.domain.Customer;

public interface DeliveryAddressService {
	
	void addAddress(String steet, String houseNumber, String town, String postalCode, Customer customer);
}
