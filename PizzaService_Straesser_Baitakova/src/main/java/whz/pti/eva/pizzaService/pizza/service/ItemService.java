package whz.pti.eva.pizzaService.pizza.service;

import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.domain.PizzaSize;

public interface ItemService {
	Item newItem(Pizza pizza, PizzaSize size, int quantity);
}
