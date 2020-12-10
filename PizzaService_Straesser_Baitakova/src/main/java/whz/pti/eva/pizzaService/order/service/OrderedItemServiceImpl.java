package whz.pti.eva.pizzaService.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.order.domain.OrderedItem;
import whz.pti.eva.pizzaService.order.domain.OrderedItemRepository;
import whz.pti.eva.pizzaService.order.domain.OrderedRepository;
import whz.pti.eva.pizzaService.pizza.domain.PizzaSize;

@Service
public class OrderedItemServiceImpl implements OrderedItemService {
	
	private OrderedItemRepository orderedItemRepository;

	@Autowired
	public OrderedItemServiceImpl(OrderedItemRepository orderedItemRepository) {
		this.orderedItemRepository = orderedItemRepository;
	}

	@Override
	public OrderedItem newOrderedItem(String pizzaName, Long pizzaId, int quantity, Long userId, PizzaSize size) {
		OrderedItem orderedItem = new OrderedItem();
		orderedItem.setName(pizzaName);
		orderedItem.setPizzaId(pizzaId);
		orderedItem.setQuantity(quantity);
		orderedItem.setUserId(userId);
		orderedItem.setSize(size);
		orderedItemRepository.save(orderedItem);
		return orderedItem;
	} 
}
