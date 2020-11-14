package whz.pti.eva.pizzaService.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.OrderedRepository;

@Service
public class OrderedService {

	private OrderedRepository orderedRepository;

	@Autowired
	public OrderedService(OrderedRepository orderedRepository) {
		this.orderedRepository = orderedRepository;
	} 	
}
