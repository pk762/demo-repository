package whz.pti.eva.pizzaService.pizza.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.ItemRepository;
import whz.pti.eva.pizzaService.pizza.domain.PizzaRepository;

@Service
public class ItemService {

	private ItemRepository itemRepository; 
	private PizzaService pizzaService; 
	
	@Autowired
	public ItemService(ItemRepository itemRepository, PizzaService pizzaService) {
		this.itemRepository = itemRepository; 
		this.pizzaService = pizzaService; 
	}
	
	
}
