package whz.pti.eva.pizzaService.order.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import whz.pti.eva.pizzaService.common.BaseEntity;

@Entity
public class Ordered extends BaseEntity<Long>{
 
	private int numberOfItems;
	private Long userId;
	
	@OneToMany
	private List<OrderedItem> orderedItems;

	public Ordered() {
		this.orderedItems = new ArrayList<OrderedItem>();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public void increaseNumberOfItems() {
		this.numberOfItems++;
	}
	public List<OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public Ordered addOrderedItems(OrderedItem orderedItem) {
		orderedItems.add(orderedItem);
		return this;
	}

}
