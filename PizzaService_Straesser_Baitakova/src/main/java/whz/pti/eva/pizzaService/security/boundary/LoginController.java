package whz.pti.eva.pizzaService.security.boundary;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
    private HttpServletRequest request;
	
	@RequestMapping(value = {"/signin"}, method = RequestMethod.GET)
	public String getLoginPage(@RequestParam Optional<String> error, Model model) {
		return "signIn";
	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		return "menu";
	}
}
