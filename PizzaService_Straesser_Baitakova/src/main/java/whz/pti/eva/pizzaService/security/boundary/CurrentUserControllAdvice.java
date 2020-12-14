package whz.pti.eva.pizzaService.security.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import whz.pti.eva.pizzaService.security.domain.CurrentCustomer;
import whz.pti.eva.pizzaService.security.service.customer.CustomerServiceImpl;


@ControllerAdvice
public class CurrentUserControllAdvice {

	private static final Logger log = LoggerFactory.getLogger(CurrentUserControllAdvice.class);

	@ModelAttribute("currentUser")
	    public CurrentCustomer getCurrentUser(Authentication authentication) {
	        log.debug("authentication = " + authentication);
	        return (authentication == null) ? null : (CurrentCustomer) authentication.getPrincipal();
	    }
}
