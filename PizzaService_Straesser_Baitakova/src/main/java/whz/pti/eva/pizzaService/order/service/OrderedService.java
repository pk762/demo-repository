package whz.pti.eva.pizzaService.order.service;

import java.util.List;
import java.util.Optional;

import whz.pti.eva.pizzaService.order.domain.Ordered;
import whz.pti.eva.pizzaService.order.domain.OrderedItem;

public interface OrderedService{
	void addOreredItem(Ordered ordered, OrderedItem orderedItem);
	List<Ordered> listOfAllOrdereds();
	Optional<List<Ordered>> listOfAllOrderedFromCustomer(Long customerId);
}
