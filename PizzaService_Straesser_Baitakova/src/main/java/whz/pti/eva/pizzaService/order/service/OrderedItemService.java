package whz.pti.eva.pizzaService.order.service;

import whz.pti.eva.pizzaService.order.domain.OrderedItem;
import whz.pti.eva.pizzaService.pizza.domain.PizzaSize;

public interface OrderedItemService {

	OrderedItem newOrderedItem(String pizzaName, Long pizzaId, int quantity, Long userId, PizzaSize size);
}
