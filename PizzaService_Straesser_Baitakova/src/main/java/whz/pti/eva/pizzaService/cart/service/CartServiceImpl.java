package whz.pti.eva.pizzaService.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.cart.domain.Cart;
import whz.pti.eva.pizzaService.cart.domain.CartRepository;
import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.security.domain.Customer;

@Service
public class CartServiceImpl implements CartService {
	
	private CartRepository cartRepository ; 
	@Autowired
	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository; 
	}
	
	@Override
	public Optional<Cart> getCart(Long id) {
		return cartRepository.findByUserId(id);
	}
	@Override
	public void newCart(Customer customer) {
		Cart cart = new Cart();
	}
	@Override
	public void addToCart(Cart cart, Item item) {
		cart.addItem(item);
		cartRepository.save(cart);
	}
	
}
