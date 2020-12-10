package whz.pti.eva.pizzaService.security.service.customer;


import java.util.Collection;
import java.util.Optional;

import whz.pti.eva.pizzaService.security.domain.Customer;
import whz.pti.eva.pizzaService.security.domain.CustomerCreateForm;
import whz.pti.eva.pizzaService.security.service.dto.CustomerDTO;


public interface CustomerService {
	CustomerDTO getCustomerById(long id);
	Optional<Customer> getCustomerByLoginName(String loginName);
    boolean existsByLoginName(String loginName);
    Collection<CustomerDTO> getAllUsers();
    Customer create(CustomerCreateForm form);
}
