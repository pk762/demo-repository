package whz.pti.eva.pizzaService.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.OrderedItemRepository;
import whz.pti.eva.pizzaService.pizza.domain.OrderedRepository;

@Service
public class OrderedItemService {
	
	private OrderedItemRepository orderedItemRepository;

	@Autowired
	public OrderedItemService(OrderedItemRepository orderedItemRepository) {
		this.orderedItemRepository = orderedItemRepository;
	} 
}
