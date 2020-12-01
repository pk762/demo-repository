package whz.pti.eva.pizzaService.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.CartRepository;
import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.pizza.domain.PizzaSize;

@Service
public class CartServiceImpl implements CartService {
	
	private CartRepository cartRepository ; 
	private PizzaService pizzaService;
	@Autowired
	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository; 
	}
	
	

}
