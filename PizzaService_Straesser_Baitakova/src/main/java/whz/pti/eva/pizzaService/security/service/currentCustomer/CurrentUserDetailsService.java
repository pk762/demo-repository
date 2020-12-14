package whz.pti.eva.pizzaService.security.service.currentCustomer;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import whz.pti.eva.pizzaService.security.domain.CurrentCustomer;
import whz.pti.eva.pizzaService.security.domain.Customer;
import whz.pti.eva.pizzaService.security.service.customer.CustomerService;


@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CurrentUserDetailsService.class);
    private CustomerService customerService;
    
    @Autowired
    public CurrentUserDetailsService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public CurrentCustomer loadUserByUsername(String loginName) throws UsernameNotFoundException {
    	log.info("Authenticating user with email={}", loginName.replaceFirst("@.*", "@***"));
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String password = request.getParameter("password"); // get from request parameter
        Customer customer = 
        		customerService.getCustomerByLoginName(loginName).orElseThrow(() -> 
        		new UsernameNotFoundException("User with email= " + loginName + " cannot be not found"));
        
        return new CurrentCustomer(customer);
    }

}
