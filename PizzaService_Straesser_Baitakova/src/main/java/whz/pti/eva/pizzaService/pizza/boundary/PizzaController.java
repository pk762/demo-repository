package whz.pti.eva.pizzaService.pizza.boundary;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.pizzaService.cart.domain.Cart;
import whz.pti.eva.pizzaService.cart.service.CartService;
import whz.pti.eva.pizzaService.common.CurrentUserUtil;
import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.domain.PizzaSize;
import whz.pti.eva.pizzaService.pizza.service.ItemService;
import whz.pti.eva.pizzaService.pizza.service.PizzaService;

@Controller
public class PizzaController {
	
	 private static final Logger log = LoggerFactory.getLogger(PizzaController.class);
	 private CartService cartService;
	 private PizzaService pizzaService;
	 private ItemService itemService;
	 @Autowired
	 public PizzaController(CartService cartService, PizzaService pizzaService,ItemService itemService ) {
		 this.cartService = cartService;
		 this.pizzaService = pizzaService;
		 this.itemService = itemService;
	 }
	 
	 @RequestMapping(value = {"/", "/menu"})
	 public String listAllPizza(Model model) {
		 List<Pizza> listOfAllPizzas = pizzaService.listOfAllPizzas();
		 model.addAttribute("listOfAllPizzas",listOfAllPizzas);
		 return "menu";
	 }
	 
	 @RequestMapping(value="addToCart", method = RequestMethod.POST)
	 public String addItemToCart(@RequestParam String pizza, @RequestParam PizzaSize size, @RequestParam int amount, Model model) {
		 Long customerID = CurrentUserUtil.getCurrentUserID(model);
		 Optional<Cart> cart = cartService.getCart(customerID);
		 cart.ifPresent(cartTemp -> {
			 System.out.println(cartTemp);
			 Item item = itemService.newItem(pizzaService.getPizzaByName(pizza).get(), size, amount);
			 cartService.addToCart(cartTemp, item);
			 System.out.println(item);
		 });
		 return "redirect:menu";
	 }
}
