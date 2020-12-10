package whz.pti.eva.pizzaService.order.boundary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import whz.pti.eva.pizzaService.common.CurrentUserUtil;
import whz.pti.eva.pizzaService.order.service.OrderedService;

@Controller
public class OrderController {

	private OrderedService orderedService;
	
	@Autowired
	public OrderController(OrderedService orderedService) {
		this.orderedService = orderedService;
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value ="/order-overview")
	public String getOrdersOverview(Model model) {
		model.addAttribute("listOfAllOrders", orderedService.listOfAllOrdereds());
		return "ordersOverview";
	}
	
	@RequestMapping(value ="/orders")
	public String getOrders(Model model) {
		Long customerID = CurrentUserUtil.getCurrentUserID(model);
		orderedService.listOfAllOrderedFromCustomer(customerID).ifPresent(list ->{
			model.addAttribute("listOfAllOrders", list);
		});
		return "ordersOverview";		
	}
	
}
