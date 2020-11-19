package whz.pti.eva.pizzaService.pizza.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ordered {

	@Id @GeneratedValue
	private Long id; 
	private int numberOfItems;
	private String userId;
	
	@OneToMany
	private List<OrderedItem> orderedItems;

	public Ordered() {
		this.orderedItems = new ArrayList<OrderedItem>();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public List<OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public Ordered addOrderedItems(OrderedItem orderedItem) {
		orderedItems.add(orderedItem);
		return this;
	}

}
