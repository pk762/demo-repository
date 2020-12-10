package whz.pti.eva.pizzaService.pizza.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.pizza.domain.ItemRepository;
import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.domain.PizzaSize;

@Service
public class ItemServiceImpl implements ItemService{

	private ItemRepository itemRepository; 

	
	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository, PizzaServiceImpl pizzaService) {
		this.itemRepository = itemRepository; 
	}

	@Override
	public Item newItem(Pizza pizza, PizzaSize size, int quantity) {
		Item item = new Item();
		item.withPizza(pizza);
		item.setSize(size);
		item.setQuantity(quantity);
		itemRepository.save(item);
		return item;
	}
	
	
	
}
