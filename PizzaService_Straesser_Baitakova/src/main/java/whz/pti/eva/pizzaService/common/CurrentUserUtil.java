package whz.pti.eva.pizzaService.common;

import org.springframework.ui.Model;

import whz.pti.eva.pizzaService.security.domain.CurrentCustomer;

public class CurrentUserUtil {
	public static String getCurrentUser(Model model) {
        CurrentCustomer currentUser = (CurrentCustomer) model.asMap().get("currentUser");
        String from = currentUser.getLoginName();
        model.addAttribute("fromUser", from);
        return from;
    }
	
	public static Long getCurrentUserID(Model model) {
        CurrentCustomer currentUser = (CurrentCustomer) model.asMap().get("currentUser");
        Long from = currentUser.getId();
        return from;
    }
}