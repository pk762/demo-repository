package whz.pti.eva.pizzaService.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.order.domain.Ordered;
import whz.pti.eva.pizzaService.order.domain.OrderedItem;
import whz.pti.eva.pizzaService.order.domain.OrderedRepository;

@Service
public class OrderedServiceImpl implements OrderedService{

	private OrderedRepository orderedRepository;
	private OrderedItemService orderedItemService;

	@Autowired
	public OrderedServiceImpl(OrderedRepository orderedRepository, OrderedItemService orderedItemService) {
		this.orderedRepository = orderedRepository;
		this.orderedItemService = orderedItemService;
	}

	@Override
	public void addOreredItem(Ordered ordered, OrderedItem orderedItem) {
		ordered.addOrderedItems(orderedItem);
		ordered.increaseNumberOfItems();
		orderedRepository.save(ordered);
	}
	
	@Override
	public List<Ordered> listOfAllOrdereds(){
		return orderedRepository.findAll();
	}
	
	@Override
	public Optional<List<Ordered>> listOfAllOrderedFromCustomer(Long customerId){
		return orderedRepository.findAllByUserId(customerId);
	}
}
