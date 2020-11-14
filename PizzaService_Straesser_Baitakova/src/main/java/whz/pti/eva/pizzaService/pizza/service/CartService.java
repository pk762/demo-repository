package whz.pti.eva.pizzaService.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.CartRepository;

@Service
public class CartService {
	
	private CartRepository cartRepository; 
	
	@Autowired
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository; 
	}

	

}
