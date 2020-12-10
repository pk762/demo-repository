package whz.pti.eva.pizzaService.pizza.service;

import java.util.List;
import java.util.Optional;

import whz.pti.eva.pizzaService.pizza.domain.Pizza;

public interface PizzaService {
	public List<Pizza> listOfAllPizzas();
	Optional<Pizza> findById(Long id);
	Optional<Pizza> getPizzaByName(String name);
}
