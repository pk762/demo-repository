package whz.pti.eva.pizzaService.cart.service;


import java.util.Optional;

import whz.pti.eva.pizzaService.cart.domain.Cart;
import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.security.domain.Customer;

public interface CartService {

	void newCart(Customer customer);
	void addToCart(Cart cart, Item item);
	Optional<Cart> getCart(Long id);
	void clearCart(Cart cart);
}
