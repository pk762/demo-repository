package whz.pti.eva.pizzaService.pizza.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.domain.PizzaRepository;

@Service
public class PizzaService {

	private PizzaRepository pizzaRepository;

	@Autowired
	public PizzaService(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	} 
	
	
	public Optional<Pizza> findById(Long id) {
		return pizzaRepository.findById(id); 
	}
}

