package whz.pti.eva.pizzaService.security.boundary;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import whz.pti.eva.pizzaService.security.domain.CurrentCustomer;



@ControllerAdvice
public class CurrentUserControllAdvice {

	 @ModelAttribute("currentUser")
	    public CurrentCustomer getCurrentUser(Authentication authentication) {
//	        LOGGER.debug("authentication = " + authentication);
	        return (authentication == null) ? null : (CurrentCustomer) authentication.getPrincipal();
	    }
}
