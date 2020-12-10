package whz.pti.eva.pizzaService.security.service.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.security.domain.Customer;
import whz.pti.eva.pizzaService.security.domain.CustomerCreateForm;
import whz.pti.eva.pizzaService.security.domain.CustomerRepository;
import whz.pti.eva.pizzaService.security.service.dto.CustomerDTO;


@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerRepository userRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomerDTO getCustomerById(long id) {
        log.debug("Getting user={}", id);
        Customer user = userRepository.findById(id).orElseThrow(() -> 
		new NoSuchElementException(String.format(">>> User=%s not found", id)));
        CustomerDTO userDTO = new CustomerDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
    
    @Override
    public Optional<Customer> getCustomerByLoginName(String loginName) {
        log.debug("Getting user by email={}", loginName.replaceFirst("@.*", "@***"));
        return userRepository.findOneByLoginName(loginName);
    }

    @Override
    public boolean existsByLoginName(String loginName) {
        return userRepository.existsByLoginName(loginName);
    }

    @Override
    public List<CustomerDTO> getAllUsers() {
        log.debug("Getting all users");
        List<Customer> targetListOrigin = userRepository.findAllByOrderByLastNameAsc(); 
		List<CustomerDTO> targetList= new ArrayList<>(); 
		for (Customer source: targetListOrigin ) {
		  	 CustomerDTO target= new CustomerDTO();
		     BeanUtils.copyProperties(source , target);
		     targetList.add(target);
		}
        return targetList;
    }

    @Override
    public Customer create(CustomerCreateForm form) {
    	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        Customer customer = new Customer();
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setLoginName(form.getLoginName());
        customer.setPasswordHash(passwordEncoder.encode(form.getPassword()));
        customer.setRole(form.getRole());
        return userRepository.save(customer);
    }


}
