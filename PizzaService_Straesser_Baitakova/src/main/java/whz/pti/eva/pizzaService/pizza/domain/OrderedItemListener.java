package whz.pti.eva.pizzaService.pizza.domain;

import javax.persistence.PrePersist;

public class OrderedItemListener {
	@PrePersist
	public void methodInvokedBeforePersist(OrderedItem orderedItem) {
		
	}
}
