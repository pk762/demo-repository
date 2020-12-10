package whz.pti.eva.pizzaService.cart.boundary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import whz.pti.eva.pizzaService.cart.domain.Cart;
import whz.pti.eva.pizzaService.cart.service.CartService;
import whz.pti.eva.pizzaService.common.CurrentUserUtil;
import whz.pti.eva.pizzaService.pizza.domain.Item;


@Controller
public class CartController {
	private CartService cartService;
	
	@Autowired
	 public CartController(CartService cartService) {
		 this.cartService = cartService;
	 }
	
	 @RequestMapping(value ="/cart")
	 public String listAllPizza(Model model) {
		 Long customerID = CurrentUserUtil.getCurrentUserID(model);
		 Optional<Cart> cart = cartService.getCart(customerID);
		 cart.ifPresent( cartTemp -> {
			 System.out.println(cartTemp);
			 System.out.println(cartTemp.getItemList());
			 List<Item> items = cartTemp.getItemList();
			 model.addAttribute("listOfAllItems",items);
		 });
		 return "cart";
	 }
}
