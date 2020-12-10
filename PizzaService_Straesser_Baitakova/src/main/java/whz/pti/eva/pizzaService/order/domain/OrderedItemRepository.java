package whz.pti.eva.pizzaService.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long> {
	
}
